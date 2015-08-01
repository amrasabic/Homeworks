package ba.bitcamp.homeworkBasicComponents.task03;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Napisati program koji daje korisniku moguccnost da se uloguje. Dvije
 * informacije trebaju biti unessene, a to su korisniccko ime i lozinka. Taccna
 * kombinacija je „Mujo“ i sifra „1234“. Neka program ne sadrzzi dugme koje
 * uloguje korisnika. Umjesto toga neka tipka Enter (kada korisnik unosi
 * lozinku) sluzi kao zamjena. Ukoliko se korisnik uspjessno uloguje onda
 * izacci iz aplikacije, a ukoliko je pogresno onda izbaciti mali prozorcic
 * koji kaze da ne valja ili korisnicko ime ili lozinka.
 * 
 * @author amra.sabic
 *
 */
public class Login extends JFrame {

	private static final long serialVersionUID = -727318018674110881L;
	// declaration of parameters
	private JLabel nameLabel = new JLabel("Name: ");
	private JLabel passLabel = new JLabel("Pass: ");
	private JTextField name = new JTextField();
	private JPasswordField pass = new JPasswordField();
	/*
	 * Constructor
	 */
	public Login() {
		// setting layout for frame
		setLayout(new GridLayout(2, 2, 5, 5));
		// setting alignment for label
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		// adding label to frame
		add(nameLabel);
		// adding text field to frame and password label
		add(name);
		add(passLabel);
		// setting alignment for label
		passLabel.setHorizontalAlignment(JLabel.CENTER);
		// adding password field to frame
		add(pass);
		// adding action listener
		pass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// values that are correct
				String correctPassword = "1234";
				String correctName = "Mujo";
				String givenName = String.valueOf(name.getText());
				String givenPassword = String.valueOf(pass.getPassword());
				// comparing entered password if the are the same exit
				// if any or both values are false, open dialog box with info
				if (correctPassword.equals(givenPassword)
						&& correctName.equals(givenName)) {
					System.exit(0);
				} else if (!correctPassword.equals(givenPassword)
						&& !correctName.equals(givenName)) {
					JOptionPane.showMessageDialog(null,
							"Password and username not correct");
				} else if (!correctPassword.equals(givenPassword)
						&& correctName.equals(givenName)) {
					JOptionPane.showMessageDialog(null, "Password not correct");
				} else if (correctPassword.equals(givenPassword)
						&& !correctName.equals(givenName)) {
					JOptionPane.showMessageDialog(null, "Username not correct");
				}
			}

		});
		// setting title, size, location, default close operation and visibility
		setTitle("Login");
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Login();
	}

}