package ba.bitcamp.homework24;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Napraviti mreznu aplikaciju na kojoj kontinualno mogu komunicirati, tj.
 * chatati, Client i Server. Ovo smo vec uradili. Server posalje neku poruku
 * Clientu-u, pa zatim Client Server-u, pa ponovo Server salje Client-u, itd.
 * 
 * Ovaj put dodati GUI na to tako da postoji polje gdje se unosi poruka, kao i
 * neka komponenta koja prikazuje dosadasnje poruke.
 * 
 * DODATNE FUNKCIJE: - Ukoliko se posalje poruka tipa /web www.google.ba onda se
 * na drugom racunaru treba otvoriti browser i pokrenuti navedena stranica (u
 * ovom slucaju google.ba).
 * 
 * - Ukoliko se posalje poruka tipa /open C:/Program Files/Games/Minesweeper.exe
 * onda se na drugom racunaru treba pokrenuti dati file (u ovom slucaju igra
 * minesweeper). Dati direktorij i file se nalaze na drugom racunaru, ne na
 * prvom.
 * 
 * - Ukoliko se posalje poruka tipa /delete C:/Program
 * Files/Games/Minesweeper.exe onda se treba obrisati dati file sa drugog
 * racunara.
 * 
 * - Ukoliko se posalje poruka tipa /list C:/Documents onda ce drugi racunar
 * poslati prvom spisak direktorija koji se nalaze na datoj lokaciji (u ovom
 * slucaju Documents folder sa C diska). Zatim, prvi racunar ispisuje sebi taj
 * spisak direktorija.
 * 
 * @author amra.sabic
 *
 */
public class Client extends JFrame {

	private static final long serialVersionUID = -7700195960725293077L;
	// declaration of parameters
	private Socket server;
	private JPanel panel = new JPanel();
	private JTextArea area = new JTextArea();
	private JTextField field = new JTextField();

	private ArrayList<String> directories = new ArrayList<String>();

	/**
	 * Constructor
	 */
	public Client() {
		// set Layout
		panel.setLayout(new BorderLayout());
		// adding components to panel
		panel.add(area, BorderLayout.CENTER);
		panel.add(field, BorderLayout.SOUTH);
		// set borders on field and area
		area.setBorder(BorderFactory.createTitledBorder("Chat "));
		area.setEditable(false);
		field.setBorder(BorderFactory.createTitledBorder("Message: "));

		field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// if key pressed is enter
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !field.getText().equals("")) {
					BufferedWriter bw;
					try {
						bw = new BufferedWriter(new OutputStreamWriter(server
								.getOutputStream()));

						bw.write(field.getText());
						bw.newLine();
						bw.flush();
						area.append("CLIENT: " + field.getText() + "\n");
						// https://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
						//  the text area automatically scrolls so that the appended text is visible
						area.setCaretPosition(field.getDocument().getLength());
						field.setText("");

					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}

		});

		add(panel);
		setTitle("Client");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try {
			server = new Socket("localhost", 1234);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					server.getInputStream()));

			String line = "";

			while (true) {
				line = br.readLine();
				if (line.length() >= 5 && line.substring(0, 5).equals("/open")) {
					try {
						Desktop.getDesktop().open(new File(line.substring(6)));
					} catch (IllegalArgumentException e) {
						area.append("The file doesn't exist. \n");
						
					}
				} else if (line.length() >= 7
						&& line.substring(0, 7).equals("/delete")) {
					try {
						File f = new File(line.substring(8));
						f.delete();
					} catch (Exception e) {
						area.append("Failed. \n");
					}
				} else if (line.length() >= 4
						&& line.substring(0, 4).equals("/web")) {
					try {
						Desktop.getDesktop().browse(new URI(line.substring(5)));
					} catch (IOException e) {
						area.append("Failed to open site. \n");
					}
				} else if (line.length() >= 5
						&& line.substring(0, 5).equals("/list")) {

					try {
						File f = new File(line.substring(6));
						if (f.isDirectory()) {
							File[] files = f.listFiles();
							for (File file : files) {
								if (file.isDirectory()) {
									directories.add(file.getName());
								}
							}
						}
						BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(server.getOutputStream()));

						bw.write(directories.toString());
						bw.newLine();
						bw.flush();

						area.append(directories.toString());
					} catch (NullPointerException e) {
						area.append("Not a directory or wrong path. \n");
					}
				} else {
					area.append("SERVER: " + line + "\n");
				}
			}

		} catch (IOException | URISyntaxException e1) {

			e1.printStackTrace();
		}

	}

	/**
	 * Main
	 */
	public static void main(String[] args) {
		Client client = new Client();
	}
}
