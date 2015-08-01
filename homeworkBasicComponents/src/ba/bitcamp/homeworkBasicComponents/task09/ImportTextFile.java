package ba.bitcamp.homeworkBasicComponents.task09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Napraviti program gdje korisnik ima opciju da unese lokaciju datoteke koja se
 * treba ucitati. Pritiskom tipke Enter u centru prozora ce se pojaviti ucitani
 * tekst iz te datoteke. Ukoliko program ne moze procitati datoteku onda
 * napisati da ne moze. i
 * 
 * @author amra.sabic
 *
 */
public class ImportTextFile extends JFrame {
	
	private static final long serialVersionUID = -6858702091071413668L;
	// declaration of parameters
	private JTextField tf = new JTextField();
	private JTextArea ta = new JTextArea();
	private String s = "";
	private JPanel panel = new JPanel();

	/*
	 * Constructor
	 */
	public ImportTextFile() {
		// setting layout of frame
		panel.setLayout(new BorderLayout());
		// setting border layout
		panel.add(tf, BorderLayout.NORTH);
		panel.add(ta, BorderLayout.CENTER);
		// adding action listener
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// read from file
				TextIO.readFile(tf.getText() + "");
				do{
					// read line for line by line
					s += TextIO.getln() + "\n";
					// and add to text area 
					ta.setText(s);
					// do fill the end of file 
				} while(!TextIO.eof());
			}
		});
		
		add(panel);
		// setting title, size, default close operation, location and visibility
		setTitle("Import Text File");
		setSize(225, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new ImportTextFile();
	}
}
