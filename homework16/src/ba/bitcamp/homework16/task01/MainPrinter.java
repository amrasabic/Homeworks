package ba.bitcamp.homework16.task01;

public class MainPrinter {

	public static void main(String[] args) {

		// declaration of new printer
		Printer p1 = new Printer("HP");
		
		// add paper and ink to printer
		p1.addPaper(35);
		p1.addInk(75);
		// print out status
		System.out.println("Amount of paper: " + p1.getPaper());
		System.out.println("Amount of ink: " + p1.getInk());
		System.out.println();
		
		// print some pages
		p1.printPages(13);
		// print out status
		System.out.println("Amount of paper: " + p1.getPaper());
		System.out.println("Amount of ink: " + p1.getInk());
		System.out.println();
		
		// try to print some pages
		p1.printPages(10);
		// print out status
		System.out.println("Amount of paper: " + p1.getPaper());
		System.out.println("Amount of ink: " + p1.getInk());
		System.out.println();
		
		// all printed pages
		System.out.println("Number of printed pages: " + p1.allPrintedPages());
		
	}

}
