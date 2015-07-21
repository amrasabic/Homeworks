package homeworkWeekend6.task02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Napraviti GUI aplikaciju koja generise nasumicno ime i prezime. Dva JButtona
 * trebaju promijeniti ime ili prezime. Potrebno je napraviti dvije inner static
 * klase koje predstavljaju generatore imena i prezimena. Te klase u sebi imaju
 * spisak (niz) svih mogucih imena, odnosno prezimena. Obje klase sadrze samo
 * generateName() i toString() metodu.
 * 
 * @author amra.sabic
 *
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 3361729750153011092L;
	// declaration of parameters
	private String name = "First name";
	private String lastName = "Last name";
	private JLabel label = new JLabel(name + " " + lastName);
	private JButton button1 = new JButton("Name");
	private JButton button2 = new JButton("Last name");

	public Main() {
		// setting the layout
		setLayout(new BorderLayout());
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		add(label, BorderLayout.CENTER);
		// declaration of label and buttons
		label.setHorizontalAlignment(NORMAL);
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		// setting everything below in each constructor
		// in class that extends JFrame
		setResizable(true);
		setTitle("Task 02");
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Main();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// if button 1 is used generate new name
			if (e.getSource() == button1) {
				name = new Names().toString();
				label.setText(name + " " + lastName);
			} // else generate new last name
			else if (e.getSource() == button2) {
				lastName = new LastNames().toString();
				label.setText(name + " " + lastName);
			}

		}

	}

	/**
	 * Names
	 * 
	 * @author amra.sabic
	 */
	static class Names {

		protected String names[] = { "Ajla", "Selma", "Nina" };

		/**
		 * Generate name
		 * <p>
		 * Generates random name (number of name in array) using Math.random and
		 * length of name array
		 * 
		 * @return String value, name
		 */
		public String generateName() {
			String generateName = names[(int) (Math.random() * names.length)];
			return generateName;
		}

		@Override
		public String toString() {
			return generateName();
		}

	}

	/**
	 * Last names
	 * 
	 * @author amra.sabic
	 */
	static class LastNames {

		public String LastNames[] = { "Muharemovic", "Spahic", "Hodzic" };

		/**
		 * Generate name
		 * <p>
		 * Generates random last name (number of last name in array) using
		 * Math.random and length of last name array
		 * 
		 * @return String value, last name
		 */
		String generateName() {
			String generateName = LastNames[(int) (Math.random() * LastNames.length)];
			return generateName;
		}

		@Override
		public String toString() {
			return generateName();
		}
	}
}
