package homeworkWeekend6.task01;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
	
	private static final long serialVersionUID = -3037227350838747481L;
	// declaration of parameters
	private XOButton[] buttons = new XOButton[9];

	public Main() {
		// setting layout
		setLayout(new GridLayout(3, 3, 5, 5));
		// declaration of new buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new XOButton();
			// setting font
			buttons[i].setFont(new Font("Cambria", Font.BOLD, 30));
			// adding listener
			buttons[i].addActionListener(new Action(buttons[i]));
			// adding buttons
			add(buttons[i]);
		}
		
		// setting everything below in each constructor
		// in class that extends JFrame
		setResizable(false);
		setTitle("Dummy XO");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
	/**
	 * Action
	 * @author amra.sabic
	 *
	 */
	private class Action implements ActionListener {

		public Action(JButton jButton) {
			super();
		}

		public void actionPerformed(ActionEvent e) {
			// if button is 'empty' assign O
			if (((XOButton) e.getSource()).getText() == "") {
				((XOButton) e.getSource()).setText("O");
			} else {
				// else if counter is < 1 
				if (((XOButton) e.getSource()).getCounter() < 1) {
					((XOButton) e.getSource()).setCounter(((XOButton) e
							.getSource()).getCounter() + 1);
				} else {
					// else if it's O overwrite with X and vice versa
					if (((XOButton) e.getSource()).getText() == "O") {
						((XOButton) e.getSource()).setText("X");
					} else {
						((XOButton) e.getSource()).setText("O");
					}
					// reset counter
					((XOButton) e.getSource()).setCounter(0);
				}
			}
		}
	}
}