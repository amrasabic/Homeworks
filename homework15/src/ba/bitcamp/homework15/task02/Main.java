package ba.bitcamp.homework15.task02;

public class Main {

	public static void main(String[] args) {
		// declaration of parameters 
		Animal a1 = new Animal("Fox", 1, 1);
		
		// method to print status of animal
		a1.printStatus();
		// print is it a day of night 
		a1.timeOfADay();
		// change water 
		a1.levelOfWater(1);
		
		// method to print status of animal
		a1.printStatus();
		// print is it a day of night
		a1.timeOfADay();
		
		
	}

}
