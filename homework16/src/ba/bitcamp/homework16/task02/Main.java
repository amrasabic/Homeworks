package ba.bitcamp.homework16.task02;

import java.io.ObjectInputStream.GetField;

public class Main {

	public static void main(String[] args) {
		// declaration of new director
		Employee e = new Employee("Director", "Female", 1900);
		// declaration of new employees
		Employee e1 = new Employee("Adis Cehajic", "Male", 1700);
		Employee e2 = new Employee("Gordan Mashic", "Male", 1800);
		Employee e3 = new Employee("Zeljko Miljevic", "Male", 1600);
		Employee e4 = new Employee("Kerim Dragolj", "Male", 1600);
		Employee e5 = new Employee("Ajla El Tabari", "Female", 1900);
		// declaration of new firm
		Firm f = new Firm("BitCamp", e, new Employee[] { e1, e2, e3, e4, e5 });
		
		// methods and prints
		System.out.println("The number of the employees in the firm is: "
				+ f.getNumberOfEmployees() + "(not including the director).");
		
		System.out.println("The number of female employees in the firm is: "
						+ f.getNumOfFemaleEmployees() + " (not including the director).");
		System.out.println("Sum of all salaries in the firm: " + f.getAllMonthSalaries());
		// method increase each salary
		f.increaseSalaries(100);
		System.out.println("Sum of all salaries in the firm: " + f.getAllMonthSalaries());
		

	}

}