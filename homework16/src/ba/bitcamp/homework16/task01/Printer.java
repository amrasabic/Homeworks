package ba.bitcamp.homework16.task01;

public class Printer {

	// declaration of parameters
	private static int allPrintedPages = 0;
	
	private String name;
	private int currPaper;
	private int amountOfInk;
	private int printedPages;
	
	/**
	 * Default printer
	 */
	public Printer(){
		
		this.name = "DefaultPrinter";
		this.currPaper = 0;
		this.amountOfInk = 0;
		this.printedPages = 0;
	}
	/**
	 * Constructor
	 * @param name - set name for printer
	 */
	public Printer(String name){
		
		this.name = name;
		this.currPaper = 0;
		this.amountOfInk = 0;
		this.printedPages = 0;
	}
	
	public int getPaper(){
		return this.currPaper;
	}
	
	public int getInk(){
		return this.amountOfInk;
	}

	/**
	 * Does the printer has ink?
	 * @return - boolean false if not, else true
	 */
		
	public boolean hasInk(){
		
		if(this.amountOfInk == 0){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Does the printer has paper?
	 * @return - boolean false if not, else true
	 */
	public boolean hasPaper(){
		
		if(this.currPaper == 0){
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Printed pages
	 * @return - how many pages had been printed out
	 */
	public int printedPages(){
		return this.printedPages;
	}
	
	/**
	 * Add paper to printer
	 * @param numOfPages - number of pages to be added
	 */
	public void addPaper(int numOfPages){
		
		if(numOfPages + this.currPaper <= 100){
			this.currPaper += numOfPages;
		} else {
			this.currPaper = 100;
		}
	}
	
	/**
	 * Add ink to printer
	 * @param amountOfInk - amount of ink  to add
	 */
	public void addInk(int amountOfInk){
		
		if(amountOfInk + this.amountOfInk <= 100){
			this.amountOfInk += amountOfInk;
		} else {
			this.amountOfInk = 100;
		}
	}
	/**
	 * Print pages
	 * @param print - number of pages to print
	 */
	public void printPages(int print){
		
		while(this.currPaper > 0 && this.amountOfInk > 3){
			this.currPaper--;
			this.amountOfInk -= 3;
			print--;
			this.printedPages++;
		}
		allPrintedPages += this.printedPages;
	}
	
	/**
	 * toString for printing
	 * @param p - printer
	 * @return - name of printer and status, is it ready for printing
	 */
	public String toString(){
		
		String s = "";
		s += "Name of printer: " + name + "\n";
		if(this.amountOfInk > 3 && this.currPaper > 1){
			s += "Ready.";
		} else if(this.amountOfInk < 3 && this.currPaper > 1){
			s += "No ink.";
		} else if(this.amountOfInk > 3 && this.currPaper < 1){
			s += "No paper.";
		} else if(this.amountOfInk < 3 && this.currPaper < 1){
			s += "No paper nor ink.";
		} 
		
		return s;
	}
	
	/**
	 * Amount of printed pages
	 * @return - number of printed pages
	 */
	public int allPrintedPages(){
		return this.allPrintedPages;
	}

}
