package ba.bitcamp.homework.part03.task02;

import ba.bitcamp.homework.part01.task01.Computer;
import ba.bitcamp.homework.part01.task02.Network;
import ba.bitcamp.homework.part01.task04.Clients;
import ba.bitcamp.homework.part02.task01.Functionable;
import ba.bitcamp.homework.part02.task02.ArrayManipulation;

public class BusNetwork extends Network implements Functionable{
	/**
	 * Constructor
	 * @param name
	 */
	public BusNetwork(String name) {
		super(name);

	}

	@Override
	/**
	 * Add computer
	 * <p>
	 * Extend array of computers with ArrayManipulation.extendArray
	 */
	public void addComputer(Computer computer) {
		// temporary array
		Computer[] tmp;
		// extend array using array manipulation
		tmp = ArrayManipulation.extendArray(getListOfComputer());
		// add computer at end of array
		tmp[tmp.length - 1] = computer;
		// check if that new object is instance of Client
		if (computer instanceof Clients) { 
			// cast it as Client
			Clients c1 = (Clients) computer; 
			try {
				// connect it to network if its not already connected
				c1.connect(computer); 
			} catch (IllegalArgumentException e) {
				System.out.println("Computer is connected");
			}
		}

	}

	@Override
	/**
	 * Remove computer
	 * <p>
	 * Disconnect computer on last element of array and shrink array
	 * using ArrayManipulation.shrinkArray.
	 */
	public void removeComputer(Computer computer) {

		Clients clients = (Clients) computer;
		int index = 0;
		int counter = 0;

		Computer[] comps;

		for (int i = 0; i < getListOfComputer().length; i++) {
			if (getListOfComputer()[i].equals(computer)) {
				clients.disconnect();
				getListOfComputer()[i] = null;
				index = i;
			} else {
				counter++;
			}
		}
		if (counter == getListOfComputer().length) {
			throw new NullPointerException(
					"That computer doesn't exist in this network.");
		}
		comps = ArrayManipulation.shrinkArray(getListOfComputer(), index);
		setListOfComputer(comps);

	}
	/**
	 * Is functioning
	 * <p>
	 * If there are at least two computers connected returns boolean value true/
	 */
	public boolean isFunctioning() {

		int counter = 0;
		
		for (int i = 0; i < getListOfComputer().length; i++) {
			if (getListOfComputer()[i] != null) {
				counter++;
			}
		}
		if (counter >= 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString for printing
	 */
	public String toString() {
		return String.format("Number of computers: %s and this network"
				+ " is functionable? %s. \n", getListOfComputer().length, isFunctioning());
	}
}
