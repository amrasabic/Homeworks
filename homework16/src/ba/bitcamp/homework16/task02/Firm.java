package ba.bitcamp.homework16.task02;

public class Firm {
	// declaration of parameters 
	private String name;
	private Employee director;
	private Employee[] employees;

	/**
	 * Constructor
	 * @param name - name of the firm
	 * @param director - director
	 * @param employees - employees in firm
	 */
	public Firm(String name, Employee director, Employee[] workers) {
	
		this.name = name;
		this.director = director;
		this.employees = workers;
	}
	/**
	 * Get number of employees
	 * @return - number of employees
	 */
	public int getNumberOfEmployees() {
		return employees.length;
	}
	/**
	 * Get all months salaries
	 * @return - amount of monthly salaries
	 */
	public int getAllMonthSalaries() {
		int salaries = director.getMonthSalary();
		for (int i = 0; i < employees.length; i++) {
			salaries += employees[i].getMonthSalary();
		}
		return salaries;
	}
	/**
	 * Get number of female employees not including director
	 * @return - number of female employees
	 */
	public int getNumOfFemaleEmployees() {
		
		int counter = 0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getGender().equals("Female")) {
				counter++;
			}  
		}	
		return counter;
	}
	/**
	 * Increase salaries
	 * @param increase - amount of money to increase salaries with
	 */
	public void increaseSalaries(int increase) {
		director.setMonthSalary(director.getMonthSalary() + increase);
		for (int i = 0; i < employees.length; i++) {
			employees[i].setMonthSalary(employees[i].getMonthSalary() + increase);
		}
	}

	/**
	 * to String method for printing out the class above
	 */
	public String toString(){
		
		String s = "Firm: " + name + "\n";
		s += "Director: " + director.getName() + "\n";
		s += "Number of employees: " + employees.length;
		return s;
	}

}