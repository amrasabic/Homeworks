package ba.bitcamp.homework.part01.task04;

import ba.bitcamp.homework.part01.task01.Computer;
import ba.bitcamp.homework.part01.task02.Network;

public class Clients extends Computer implements Connectable {
	// declaration of parameters
	private Computer computer;
	private Network network;

	/**
	 * Constructor
	 * @param name - computer name
	 * @param MACAddress - MAC address of the computer
	 */
	public Clients(String name, char[] MACAddress) {
		super(name, MACAddress);

	}
	// getters
	public Computer getComputer() {
		return computer;
	}

	public Network getNetwork() {
		return network;
	}

	/**
	 * Disconnect
	 * <p>
	 * Sets both values to null.
	 */
	public void disconnect() {
		this.computer = null;
		this.network = null;
	}

	/**
	 * Connect to computer
	 * <p>
	 * Sets value of computer to value of method parameter, if it is a value != null
	 * @throws IllegalArgumentException 
	 */
	public void connect(Computer c) throws IllegalArgumentException {

		if (computer != null) {
			throw new IllegalArgumentException("Client already has computer.");
		} else {
			computer = c;
		}

	}
	/**
	 * Connect to network
	 * <p>
	 * Sets value of network to value of method parameter, if it is a value != null
	 * @throws IllegalArgumentException 
	 */
	public void connect(Network n) {

		if (network != null) {
			throw new IllegalArgumentException("Client already has network.");
		} else {
			network = n;
		}

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		if (computer == null) {
			if (other.computer != null)
				return false;
		} else if (!computer.equals(other.computer))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		return true;
	}

	/**
	 * toString for printing
	 */
	@Override
	public String toString() {
		return String.format("Client computer: %s, and network: %s.", computer,
				network);
	}

}
