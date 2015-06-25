package ba.bitcamp.practicingClasses.task01;

public class Rectangle {
	
	// declaration of parameters 
	private int a;
	private int b;
	
	/**
	 * Constructor
	 * @param a - side a of rectangle
	 * @param b - side b of rectangle
	 */
	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Area of Rectangle
	 * @return area - area of rectangle
	 */
	public int getRectArea() {
		return a*b;
	}
	
	/**
	 * Volume of Rectangle
	 * @return volume - volume of rectangle
	 */
	public int getRectVolume() {
		return (2*a) + (2*b);
	}
}
