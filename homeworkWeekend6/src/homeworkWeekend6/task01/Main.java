package homeworkWeekend6.task01;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Napraviti GUI aplikaciju koja prikaze deset cifara na JFrame (od 0 do 9).
 * Generisati trocifren broj pomocu tih deset cifara. Kada se generise trocifren
 * broj prikazati na ekran generisani broj i zatvoriti aplikaciju. Na primjeru
 * ispod korisnik pritisne 1, pa 8, pa 9 što generise trocfireni broj 189.
 * 
 * @author amra.sabic
 *
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 2831713870966086321L;
	// declaration of parameters
	private JButton[] buttons = new JButton[10];
	private int counter = 0;
	public static String num = "Result is ";

	/**
	 * Constructor
	 */
	public Main() {
		// setting the layout
		setLayout(new GridLayout(10, 1));
		// declaration of new buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i) + "");
			// setting font
			buttons[i].setFont(new Font("Arial", Font.BOLD, 18));
			// adding listener
			buttons[i].addActionListener(new Action());
			// adding buttons
			add(buttons[i]);
		}
		// setting everything below in each constructor
		// in class that extends JFrame
		setResizable(true);
		setTitle("Task 01");
		setSize(200, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Main();
	}

	/**
	 * Action listener
	 * @author amra.sabic
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// for loop through buttons length
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					// on each click enable buttons is set to false
					if (e.getSource() == buttons[i] && counter < 3) {
						buttons[i].setEnabled(false);
						// add number of that button to string
						num += buttons[i].getText();
						// counter ++ until it reach 3
						counter++;
					}
					// if counter is equal to 3
					if (counter == 3) {
						// open message dialog and write 
						JOptionPane.showMessageDialog(null, num);
						System.exit(0);
					}

				}
			}
		}

	}
}
