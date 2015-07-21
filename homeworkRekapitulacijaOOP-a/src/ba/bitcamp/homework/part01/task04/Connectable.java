package ba.bitcamp.homework.part01.task04;

import ba.bitcamp.homework.part01.task01.Computer;
import ba.bitcamp.homework.part01.task02.Network;

public interface Connectable {
	/**
	 * Connect to Computer
	 * @param c - computer to connect to
	 */
	public void connect(Computer c);

	/**
	 * Connect to Network
	 * @param n - network to connect to
	 */
	public void connect(Network n);

	/**
	 * Disconnect
	 * <p>
	 * TIP: set values to null
	 */
	public void disconnect();

}