package ba.bitcamp.homeworkBasicComponents.task06;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Napraviti program gdje korisnik unese vrijednost vremena u sekundama. Zatim
 * ce korisnik pritisnuti dugme da zapocne odbrojavanje. To odbrojavanje ce biti
 * predstavljeno na tom prozoru. Kada brojac stigne do nule zaustaviti brojanje
 * i cekati da se ponovo unese vrijeme.
 * 
 * @author amra.sabic
 *
 */
public class Countdown extends JFrame {

	private static final long serialVersionUID = 6420873984634210161L;
	// declaration of parameters
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private JTextField field = new JTextField(20);
	private JButton button = new JButton("Count!");
	private Font f = new Font("Serif", Font.BOLD, 25);

	/*
	 * Constructor
	 */
	public Countdown() {
		// timer
		Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(label.getText());
				if (num > 0) {
					label.setText("" + (num - 1));
				}
			}
		});
		// panel layout 
		panel.setLayout(new GridLayout(3, 1));
		// setting label text, alignment and font
		label.setText(field.getText());
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(f);
		// and adding label to panel
		panel.add(label);
		// setting text field alignment and adding it to panel
		field.setHorizontalAlignment(JTextField.CENTER);
		panel.add(field);
		// button action listener
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("" + field.getText());
				t.start();
			}
		});
		// add button to panel
		panel.add(button);
		// add panel to frame
		add(panel);
		// setting title, size, default close operation, location and visibility
		setTitle("Countdown");
		setSize(225, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Countdown();
	}

}
