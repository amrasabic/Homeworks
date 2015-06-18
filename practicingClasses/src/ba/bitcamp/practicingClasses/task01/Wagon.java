package ba.bitcamp.practicingClasses.task01;

public class Wagon {

	// declaration of parameters 
	private Rectangle platform;
	private Circle[] wheels;
	
	/**
	 * Constructor
	 * @param platform - platform of the wagon
	 * @param wheels - wheels of the wagon
	 */
	public Wagon(Rectangle platform, Circle[] wheels) {
	
		this.platform = platform;
		this.wheels = wheels;
	}
	
	/**
	 * Get wagon area 
	 * @return area - area of wagon
	 */
	public double getWagonArea() {
		// initialize area of wagon as area of platform
		double area = platform.getRectArea();
		// add area of each wheel to it
		for(int i = 0; i < wheels.length; i++) {
			area += wheels[i].getCircleArea();
		}
		return area;
	}
	
	/**
	 * Get wagon volume
	 * @return volume - volume of wagon
	 */
	public double getWagonVolume() {
		// initialize volume of wagon as volume of platform
		double volume = platform.getRectVolume();
		// add volume of each wheel to it
		for(int i = 0; i < wheels.length; i++) {
			volume += wheels[i].getCircleVolume();
		}
		return volume;
	}
}
