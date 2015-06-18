package ba.bitcamp.practicingClasses.task01;

public class Square {

	// declaration of parameters 
	private int a;
	
	/**
	 * Constructor
	 * @param a - side of a square
	 */
	public Square(int a) {
		this.a = a;
	}
	
	/**
	 * Get square area
	 * <p>
	 * Calculates area of square
	 * @return a*a - area of square 
	 */
	public int getSquareArea() {
		return a*a;
	}
	
	/**
	 * Volume of square
	 * <p>
	 * Calculates volume of Square objects
	 * @return volume - volume of square
	 */
	public int getSquareVolume() {
		return a*4;
	}
}
