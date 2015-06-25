package ba.bitcamp.practicingClasses.task01;

public class Locomotive {

	// declaration of parameters 
	private Circle[] wheels;
	private Circle[] windows;
	private Rectangle mainRectangle;
	private Rectangle chimney;
	private Square cabin;
	
	/**
	 * Constructor
	 * @param wheels - array of wheels
	 * @param windows - array of windows
	 * @param mainRectangle
	 * @param chimney
	 * @param cabin
	 */
	public Locomotive(Circle[] wheels, Circle[] windows, Rectangle mainRectangle,
			Rectangle chimney, Square cabin) {

		this.wheels = wheels;
		this.windows = windows;
		this.mainRectangle = mainRectangle;
		this.chimney = chimney;
		this.cabin = cabin;
	}
	
	/**
	 * Get Locomotive Area
	 * @return area - area of locomotive that need to be painted
	 */
	public double getLocomotiveArea() {	
		
		// add separated parts of locomotive to the whole area
		double area = chimney.getRectArea() + cabin.getSquareArea()
				+ mainRectangle.getRectArea();
		// add array of wheels, by that meaning area of each one of them
		for (int i = 0; i < wheels.length; i++) {
			area += wheels[i].getCircleArea();
		}
		// reduce area of locomotive with array of windows cause they don't need to be painted
		for (int i = 0; i < windows.length; i++) {
			area -= windows[i].getCircleArea();
		}
		return area;
	}
	
	/**
	 * Get locomotive volume
	 * @return volume - locomotive volume
	 */
	public double getLocomotiveVolume() {
		
		// add volumes of each part of locomotive to volume
		double volume = chimney.getRectVolume() + cabin.getSquareVolume()
				+ mainRectangle.getRectVolume();
		// add volumes of array of wheels
		for (int i = 0; i < wheels.length; i++) {
			volume += wheels[i].getCircleVolume();
		}
		// add volumes of array of windows
		for (int i = 0; i < windows.length; i++) {
			volume += windows[i].getCircleVolume();
		}
		return volume;
	}	
}
