package ba.bitcamp.homeworkFiles;

import javax.swing.JFrame;

/**
 * Frame and components including main method
 * 
 * @author amra.sabic
 *
 */
public class TextEditor extends JFrame {

	private static final long serialVersionUID = -7451136837445928827L;

	// declaration of parameters
	private Panel panel = new Panel();

	/**
	 * Constructor
	 */
	public TextEditor() {

		// adding panel to frame
		add(panel);
		// as always setting title, size, location, default close operation and
		// at the very end visibility
		setTitle("Text Editor");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
	}
}