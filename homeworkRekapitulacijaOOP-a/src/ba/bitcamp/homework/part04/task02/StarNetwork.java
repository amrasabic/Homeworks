package ba.bitcamp.homework.part04.task02;

import ba.bitcamp.homework.part01.task01.Computer;
import ba.bitcamp.homework.part01.task02.Network;
import ba.bitcamp.homework.part01.task03.Server;
import ba.bitcamp.homework.part01.task04.Clients;
import ba.bitcamp.homework.part02.task01.Functionable;
import ba.bitcamp.homework.part02.task02.ArrayManipulation;

public class StarNetwork extends Network implements Functionable {

	private Server server;
	/**
	 * Constructor
	 * @param name
	 * @param server
	 */
	public StarNetwork(String name, Server server) {
		super(name);
		this.server = server;
	}

	@Override
	/**
	 * Is functioning
	 * <p>
	 * Boolean value true if there are less then or equal to max computers 
	 * on server.
	 */
	public boolean isFunctioning() {

		int counter = 0;

		for (int i = 0; i < getListOfComputer().length; i++) {
			Clients c = (Clients) getListOfComputer()[i];
			if (c.getComputer() == this.server) {
				counter++;
			}
		}

		if (counter > server.getMaxComputers()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	/**
	 * Add computer
	 * <p>
	 * Extend array of computers with ArrayManipulation.extendArray
	 */
	public void addComputer(Computer computer) {

		Computer[] comps;
		comps = ArrayManipulation.extendArray(getListOfComputer());
		comps[comps.length - 1] = computer;
		Clients k = (Clients) computer;
		k.connect(this.server);
		setListOfComputer(comps);

	}

	@Override
	/**
	 * Remove computer
	 * <p>
	 * Disconnect computer on last element of array and shrink array
	 * using ArrayManipulation.shrinkArray.
	 */
	public void removeComputer(Computer computer) {

		Clients k = (Clients) computer;
		int index = 0;
		int counter = 0;

		Computer[] comps;

		for (int i = 0; i < getListOfComputer().length; i++) {
			if (getListOfComputer()[i].equals(computer)) {
				k.disconnect();
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
	 * toString for printing
	 */
	public String toString() {
		return String.format("Number of computers: %s and this network"
				+ " is functionable? %s. \n", getListOfComputer().length,
				isFunctioning());
	}
}
