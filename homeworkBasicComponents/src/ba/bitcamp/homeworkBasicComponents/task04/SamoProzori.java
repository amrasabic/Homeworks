package ba.bitcamp.homeworkBasicComponents.task04;

import javax.swing.JOptionPane;

/**
 * Koristeci samo JOptionPane klasu za GUI napraviti program koji pita korisnika
 * da unese broj. Zatim pita korisnika da li zeli unijeti jos jedan broj.
 * Ukoliko kaze da nece onda izbaciti sumu svih brojeva do tog. Ako kaze da hoce
 * onda vratiti se nazad na prvi korak i tako u krug. Ukoliko korisnik ode na
 * „Cancel“ onda samo zatvoriti aplikaciju, a ako pritisne „Cancel“ pri unosu
 * brojeva onda ispisati sumu, a ukoliko unese pogresnu vrijednost (recimo
 * slova) onda izbaciti gresku i zatvoriti program.
 * 
 * @author amra.sabic
 *
 */
public class SamoProzori {

	public static int sum = 0;
	public static int number;
	public static int choice;
	
	
	public static void main(String[] args) {
		// try and catch number format exception, if it happens exit
		try {
			do {
				// if number is entered open dialog to enter new number
				number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
				// open input dialog to enter number
				choice = JOptionPane.showConfirmDialog(null, "Do you wanna insert new number?");
				// add number to sum
				sum += number;
			} while (choice == JOptionPane.YES_OPTION);
			// if on second dialog click is no option show sum of numbers
			if (choice == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Sum: " + sum);
			}
			// if cancel option click exit
			if (choice == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}

		} catch (NumberFormatException e) {
			System.exit(0);
		}
	}
}