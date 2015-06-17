package ba.bitcamp.homework15.task01;

public class Strongbox {
	// declaration of parameters 
	private String name;
	private int money;
	
	/**
	 * Constructor
	 * @param name - name of the strongbox
	 * @param money - amount of money in strongbox
	 */
	public Strongbox(String name) {
		
		this.name = name;
		this.money = 0;
	}

	/**
	 * to String method for printing out the class above
	 */
	public String toString() {
		return "Strongbox name: " + name + ", money " + money + "\n";
	}
	
	/**
	 * Add money to strongbox
	 * @param a - amount to add
	 * @return - new balance
	 */
	public int addMoney(int a){
		
		return money += a;
		
	}
	/**
	 * Withdraw money from strongbox
	 * @param a - amount withdraw
	 * @return - new balance
	 */
	public void withdraw(){
		
		money -= money;
	}
	/**
	 * Print information - how much money is in strongbox
	 */
	public void printInformation(){
		
		if(money == 0){
			System.out.println("It's empty.");
		} else if(money > 1 && money <= 20){
			System.out.println("There’s some, but not much.");
		} else if(money > 21 && money <= 100){
			System.out.println("There’s some.");
		} else {
			System.out.println("There’s a lot.");
		}
		
	}
}
