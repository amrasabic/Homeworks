package ba.bitcamp.homework16.task01;

public class MainTemperature {

	public static void main(String[] args) {
		
		// declaration of new temperature
		Temperature t = new Temperature(23);
		// set new value for temperature
		t.setTemperature(0);
		// method to convert to C
		System.out.println(t.getTemperatureInC() + " Celsius");
		// method to convert to K
		System.out.println(t.getTemperatureInK() + " Kelvins");
		// method to convert to F
		System.out.println(t.getTemperatureInF() + " Fahrenheits");
		
	}

}
