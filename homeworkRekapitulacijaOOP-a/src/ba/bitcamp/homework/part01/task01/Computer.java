package ba.bitcamp.homework.part01.task01;

public abstract class Computer {
	// declaration of parameters
	protected String name;
	protected MAC MACAddress;

	/**
	 * Constructor
	 * 
	 * @param name - computer name
	 * @param MACAddress - MAC address of the computer
	 */
	public Computer(String name, char[] MACAddress) {
		this.name = name;
		this.MACAddress = new MAC(MACAddress);
	}

	/**
	 * Constructor - empty
	 */
	public Computer() {
		this.name = "Computer";
		this.MACAddress = new MAC(new char[12]);
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MAC getMACAddress() {
		return MACAddress;
	}

	public void setMACAddress(MAC mACAddress) {
		MACAddress = mACAddress;
	}

	/**
	 * toString for printing
	 */
	public String toString() {
		return String.format("Computer name: %s, MAC address %d.", name,
				MACAddress);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Computer other = (Computer) obj;
		if (MACAddress == null) {
			if (other.MACAddress != null)
				return false;
		} else if (!MACAddress.equals(other.MACAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	// inner class
	public class MAC {
		// declaration of parameters
		private char[] MACAddress = new char[12];
		/**
		 * Constructor
		 * @param MACAddress - MAC address
		 */
		public MAC(char[] MACAddress) {
			super();
			this.MACAddress = MACAddress;
		}

		// getters and setters
		public char[] getMACAddress() {

			return MACAddress;
		}

		public void setMACAddress(char[] MACAddress) {
			this.MACAddress = MACAddress;
		}
		
		/**
		 * toString for printing
		 */
		public String toString() {

			String s = " ";
			// for loop 
			for (int i = 0; i < MACAddress.length + 5; i++) {
				// inside this loop if it's not even number add : 
				// so that print of this method would look like 12:2a:4c:43:7f:76
				if (i % 2 != 0 && i < 11) {
					s += MACAddress[i] + ":";
				} else {
					s += MACAddress[i];
				}

			}
			return s;
		}
	}

}