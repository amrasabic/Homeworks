package homeworkWeekend6.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	private static final long serialVersionUID = -6698640702139928381L;
	// declaration of parameters
	private int counter = 0;
	private int[] array = new int[5];
	private JButton buttons[] = new JButton[10];

	public Main() {
		// setting the layout
		setLayout(new GridLayout(2, 5));
		// declaration of new buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			// setting text
			buttons[i].setText(i + "");
			// adding listener
			buttons[i].addActionListener(new Action());
			// adding buttons
			add(buttons[i]);
		}

		// setting everything below in each constructor
		// in class that extends JFrame
		setResizable(true);
		setTitle("Task 03");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Main();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
}
