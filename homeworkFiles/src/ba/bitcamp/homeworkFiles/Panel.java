package ba.bitcamp.homeworkFiles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * JPanel with components, such as Menu bar with Menu File, that contains Open
 * and Save, and Text area. Including appropriate listeners.
 * 
 * @author amra.sabic
 *
 */
public class Panel extends JPanel {

	private static final long serialVersionUID = 6657913312838282054L;

	// declaration of parameters
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("File");
	private JMenuItem open = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save as");
	private JTextArea text = new JTextArea();

	/**
	 * Constructor
	 */
	public Panel() {

		text.setBorder(BorderFactory.createTitledBorder("Text Area"));

		// menu item "open" added to menu
		menu.add(open);

		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Returns the UIDefaults from the current look and feel, that
				// were obtained at the time the look and feel was installed.
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}

				// if "open" is pressed
				JFileChooser choser = new JFileChooser();
				choser.setMultiSelectionEnabled(false);
				// adding filter to this file chooser
				choser.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
				int action = choser.showOpenDialog(open);

				// if approve option "open" is pressed
				if (action == JFileChooser.APPROVE_OPTION) {
					// open selected file
					File file = choser.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(
								new FileReader(file));
						String s = "";
						// read file and set text to text area
						while (reader.ready()) {
							s += reader.readLine() + "\n";
							text.setText(s);
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		// menu item "save" added to menu
		menu.add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Returns the UIDefaults from the current look and feel, that
				// were obtained at the time the look and feel was installed.
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}

				// if save is pressed
				JFileChooser choser = new JFileChooser();
				choser.setMultiSelectionEnabled(false);
				// adding filter to this file chooser
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".txt", "txt");
				choser.setFileFilter(filter);
				int action = choser.showSaveDialog(save);

				// if approve option "save" is pressed
				if (action == JFileChooser.APPROVE_OPTION) {
					// get text from text area
					String s = text.getText();
					// this line .. does something with text and arranges it
					// properly
					s = s.replaceAll("(?!\\r)\\n", "\r\n");
					try {
						BufferedWriter writer = new BufferedWriter(
								new FileWriter(new File(choser
										.getCurrentDirectory(), choser
										.getSelectedFile().getName()
										+ filter.getDescription())));
						writer.write(s);
						writer.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		// add "menu" to menu bar
		bar.add(menu);

		// setting panel layout
		setLayout(new BorderLayout());
		// adding menu bar and text area to panel
		add(bar, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);

	}
}