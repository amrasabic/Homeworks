package ba.bitcamp.homeworkBasicComponents.task08;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Napraviti program gdje se korisnik registruje. Korisnik treba unijeti
 * korisnicko ime i dva puta treba unijeti sifru. Na dnu ekrana imaju dva
 * dugmenta, clear i submit. Clear pobrise sve unijete informacije sa prozora.
 * Submit treba pokusati registrovati korisnika. Registracija nije uspjesna kada
 * (a i treba obavijestiti korisnika zasto nije uspjela) unesene lozinke nisu
 * iste, kada je korisnicko ime ima manje od 6 karaktera, kada lozinka ima manje
 * od 6 karaktera i kada lozinka nema barem jedan broj i jedan specijalni
 * karakter.
 * 
 * @author amra.sabic
 *
 */

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1518107214654440660L;
	// declaration of parameters
	private JLabel userName = new JLabel();
	private JLabel password = new JLabel();
	private JLabel passwordConfirm = new JLabel();

	private JTextField user = new JTextField();
	private JPasswordField p1 = new JPasswordField();
	private JPasswordField p2 = new JPasswordField();

	private JButton clear = new JButton();
	private JButton submit = new JButton();

	/*
	 * Constructor
	 */
	public RegisterForm() {
		// setting layout
		setLayout(new GridLayout(4, 2));

		// setting title, size, default close operation, location and visibility
		setTitle("Import Text File");
		setSize(225, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RegisterForm();
	}

	public class Mouse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
