package ba.bitcamp.practicingClasses.task01;

public class Train {

	// declaration of parameters 
	private Locomotive cabin;
	private Wagon[] wagons;

	/**
	 * Constructor
	 * @param cabin - cabin of the train
	 * @param wagons - array of wagons
	 */
	public Train(Locomotive cabin, Wagon[] wagons) {

		this.cabin = cabin;
		this.wagons = wagons;
	}
	
	/**
	 * Get train area 
	 * @return area - area of whole train
	 */
	public double getTrainArea() {
		// initialize area of train as area of locomotive
		double area = cabin.getLocomotiveArea();
		// add areas of each wagon
		for(int i = 0; i < wagons.length; i++) {
			area += wagons[i].getWagonArea();
		}
		return area;
	}
	
	/**
	 * Get train volume 
	 * @return volume - volume of whole train
	 */
	public double getTrainVolume() {
		// initialize volume of train as volume of locomotive
		double volume = cabin.getLocomotiveVolume();
		// add areas of each wagon on it
		for(int i = 0; i < wagons.length; i++) {
			volume += wagons[i].getWagonVolume();
		}
		return volume;
	}
}
