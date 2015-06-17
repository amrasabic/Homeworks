package ba.bitcamp.homework16.task02;

public class Employee {
	// declaration of parameters 
	private String name;
	private String gender;
	private int monthSalary;
	
	/**
	 * Employee
	 * @param name - employees name
	 * @param gender - gender
	 * @param monthSalary - month salary
	 */
	public Employee(String name, String gender, int monthSalary) {
		
		this.name = name;
		this.gender = gender;
		this.monthSalary = monthSalary;
	}
	
	/**
	 * Get name
	 * @return - name of employee
	 */
	public String getName(){
		return name;
	}

	/**
	 * Get gender
	 * @return - gender of employee
	 */
	public String getGender(){
		return gender;
	}
	/**
	 * Set month salary
	 * @param salary - salary amount
	 */
	public void setMonthSalary(int salary){
		monthSalary = salary;
	}
	/**
	 * Get month salary
	 * @return - salary amount for one month
	 */
	public int getMonthSalary(){
		return monthSalary;
	}

}
