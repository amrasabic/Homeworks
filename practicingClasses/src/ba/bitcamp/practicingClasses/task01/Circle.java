package ba.bitcamp.practicingClasses.task01;

public class Circle {

	// declaration of parameter r - radius
	private int r;
		
	/**
	 * Constructor
	 * @param r - radius
	 */
	public Circle(int r) {
		this.r = r;
	}
	/**
	 * Area of circle
	 * @return area - double value for area of circle
	 */
	public double getCircleArea() {
		return (r*r)*Math.PI;
	}
	
	/**
	 * Volume of circle
	 * @return volume - double value for volume of circle
	 */
	public double getCircleVolume() {
		return (2*r) * Math.PI;
	}
}
