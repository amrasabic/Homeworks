package ba.bitcamp.homework15.task01;

public class Main {

	public static void main(String[] args) {

		Strongbox s1 = new Strongbox("Savings");
		// method add money to strongbox
		s1.addMoney(20);
		System.out.println(s1);
		// method for withdraw all money
		s1.withdraw();
		System.out.println(s1);
		//print information
		s1.printInformation();
		
	}

}
