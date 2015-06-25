package ba.bitcamp.practicingClasses.task01;

public class Painting {

	public static void main(String[] args) {
		
		// declaration of new wheel
		Circle wheel = new Circle(2);
		// declaration of new window
		Circle window = new Circle(1);
		
		// declaration of array of 2 wheels
		Circle[] wheels = {wheel, wheel};
		// declaration of array of 2 windows
		Circle[] windows = {window, window};
		
		// declaration of rectangle as platform of the wagon
		Rectangle wagRect = new Rectangle(5,10);
		// declaration of new wagon
		Wagon wagon = new Wagon(wagRect, wheels); 
		// declaration of array of wagons
		Wagon[] wagons = {wagon, wagon, wagon, wagon, wagon}; 
		
		// components of locomotive below
		Square cabin = new Square(4);
		Rectangle cabinRect = new Rectangle(4, 8);
		Rectangle chimney = new Rectangle(1,1);
		
		// declaration of new locomotive from components above
		Locomotive locomotive = new Locomotive(wheels, windows, cabinRect, chimney, cabin);
		
		// train - array of wagons and one locomotive
		Train t1 = new Train(locomotive, wagons);
		
		// print out results of two methods how much paint do we need for train area or just outer lines
		System.out.printf("To paint whole train amount of paint needed is: %.2f \n", t1.getTrainArea());
		System.out.printf("To draw lines of train amount of paint needed is: %.2f",  t1.getTrainVolume());
	}

}
