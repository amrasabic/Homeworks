package ba.bitcamp.homework.part01.task03;

import ba.bitcamp.homework.part01.task01.Computer;

public class Server extends Computer {
	// declaration of parameters
	public int maxComputers;

	/**
	 * Constructor
	* @param name - computer name
	 * @param MACAddress - MAC address of the computer
	 * @param maxComputers - number of max computers on server, limit
	 */
	public Server(String name, char[] MACAddress, int maxComputers) {
		super(name, MACAddress);
		this.maxComputers = maxComputers;
	}
	
	// getters and setters
	public int getMaxComputers() {
		return maxComputers;
	}

	public void setMaxComputers(int maxComputers) {
		this.maxComputers = maxComputers;
	}

	/**
	 * toString for printing
	 */
	@Override
	public String toString() {
		return String.format("Server (maximum computers = %d)", maxComputers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Server other = (Server) obj;
		if (maxComputers != other.maxComputers) {
			return false;
		}
		return true;
	}

}