package ba.bitcamp.homework.part01.task02;

import ba.bitcamp.homework.part01.task01.Computer;

public abstract class Network {
	// declaration of parameters
	private String name;
	private Computer[] arraytOfComputer;

	/**
	 * Constructor
	 * @param name - network name
	 * @param listOfComputer - array of computers
	 */
	public Network(String name) {
		super();
		this.name = name;
		this.arraytOfComputer = new Computer[0];
	}
	// getters and setters
	public String getName() {
		return name;
	}

	public Computer[] getListOfComputer() {
		return arraytOfComputer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setListOfComputer(Computer[] listOfComputer) {
		this.arraytOfComputer = listOfComputer;
	}

	
	public abstract void addComputer(Computer computer);

	public abstract void removeComputer(Computer computer);

}