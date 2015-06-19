package ba.bitcamp.homework16.task01;

public class Temperature {
	// declaration of parameters 
	private double temperature;
	
	/**
	 * Constructor
	 * @param temperature - Current temperature
	 */
	public Temperature(double temperature){
		this.temperature = temperature;
	}
	/**
	 * toString for printing
	 */
	public String toString(){
		return "Temperature: " + temperature;
	}
	/**
	 * Temperature in Celsius
	 * @param temp - temperature to convert to Celsius
	 * @return - same temperature
	 */
	public double getTemperatureInC(){
		return temperature;
	}
	/**
	 * Temperature in Kelvin
	 * @param temp - temperature to convert to Kelvin
	 * @return - temperature multiplied with 274.15
	 */
	public double getTemperatureInK(){
		return temperature + 273.15;
	}
	/**
	 * Temperature in Fahrenheit
	 * @param temp - temperature to convert to Fahrenheit
	 * @return - temperature multiplied with 33.8
	 */
	public double getTemperatureInF(){
		return (9/5) * temperature + 32;
	}
	/**
	 * Set current temperature
	 * @param temp - current temperature
	 */
	public void setTemperature(double temp){
		this.temperature = temp;
	}

}
