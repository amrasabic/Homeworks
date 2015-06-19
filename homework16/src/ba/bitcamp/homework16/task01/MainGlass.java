package ba.bitcamp.homework16.task01;

public class MainGlass {

	public static void main(String[] args) {

		Glass g1 = new Glass(200);
		// set liquid
		g1.setTypeOfLiquid("Water");
		System.out.println(g1);
		// try to add juice to glass with water
		g1.addLiquid("Juice", 30);
		// add water
		g1.addLiquid("Water", 130);
		System.out.println(g1);
		// empty glass
		g1.emptyGlass();
		System.out.println(g1);
	}

}
