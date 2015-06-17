package ba.bitcamp.homework15.task02;

public class Animal {
	// declaration of parameters 
	private String name;
	private int active;
	private int water;
	private static int currTime;
	private static int currWater;
	/**
	 * Animal 
	 * @param name -  animal name
	 * @param active - is that animal active at night
	 * @param water - how much water does animal need
	 */
	public Animal(String name, int active, int water) {
		
		this.name = name;
		this.active = active;
		this.water = water;
		this.currTime = 1;
		this.currWater = 1;
	}
	/**
	 * to String method for printing out the class above
	 */
	public String toString() {
		
		String s = "";
		s += "Animal name: " + name + "\n";
		
		if(active == 1){
			s += "Active during day." + "\n";
		} else if (active == 2){
			s += "Active at night." + "\n";
		} 
		
		if(water == 1){
			s += "Water: Need little water." + "\n";
		} else if (water == 2){
			s += "Water: Need more." + "\n";
		} else if (water == 3){
			s += "Water: Need a lot." + "\n";
		} 
		
		return s;
	}
	
	/**
	 * Change time 
	 * <p>
	 * If it was day change to night, and inversely.
	 */
	public void timeOfADay(){
		
		if(currTime == 1){
			currTime = 2;
			System.out.println("Night.");
		} else if (currTime == 2){
			currTime = 1;
			System.out.println("Day.");
		} 
		
	}
	
	/**
	 * Level of water
	 * <p>
	 * Just prints out level of water for specific animal.
	 */
	public void levelOfWater(){
		
		if (water == 0){
			System.out.println("Water: None.");
		} else if(water == 1){
			System.out.println("Water: Has little water.");
		} else if (water == 2){
			System.out.println("Water: Has more water.");
		} else if (water == 3){
			System.out.println("Water: Has a lot.");
		} 
	}
	/**
	 * Level of water
	 * <p>
	 * Change level of water for specific animal. 
	 */
	public void levelOfWater(int water){
		
		if (water == 0){
			currWater = 0;
		} else if(water == 1){
			currWater = 1;
		} else if (water == 2){
			currWater = 2;
		} else if (water == 3){
			currWater = 3;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Print animal status
	 * <p>
	 * Depending on animal activity and water prints animal status.
	 */
	public void printStatus(){
		
		if(active == 1 && currWater == water){
			System.out.println("It is fine. The animal is active and has water.");
		} else if(active == 1 && currWater != water){
			System.out.println("The animal is active, but does not have enough water.");
		} else if(active != 1 && currWater == water){
			System.out.println("The animal is not active, but has enough water.");
		} else if(active != 1 && currWater != water){
			System.out.println("The animal is not active and it does not have enough water.");
		}  
	}
}


