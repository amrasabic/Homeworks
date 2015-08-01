package ba.bitcamp.homeworkArrayProcessing;

public class Main {

	public static void main(String[] args) {
		
		DynamicDouble arrayDoubleOne = new DynamicDouble(3, 2.0);
		System.out.println(arrayDoubleOne.toString());
		System.out.println();
		
		arrayDoubleOne.addElement(7);
		System.out.println(arrayDoubleOne.toString());
		System.out.println();
		
		arrayDoubleOne.remove(0);
		System.out.println(arrayDoubleOne.toString());
		System.out.println();
		
		arrayDoubleOne.remove(1);
		System.out.println(arrayDoubleOne.toString());

		
		DynamicString arrayStringTwo = new DynamicString(5, "String");

		System.out.println(arrayStringTwo.toString());
		System.out.println();
		arrayStringTwo.addElement("Dynamic");
//		System.out.println(arrayStringTwo.toString());
//
		System.out.println();
		arrayStringTwo.removeSlow(0);
//		System.out.println(arrayStringTwo.toString());

		arrayStringTwo.removeSlow(0);
		System.out.println(arrayStringTwo.toString());

	}

}
