package ba.bitcamp.homework16.task01;

public class Glass {

	// declaration of parameters
	private String liquidType;
	private double amountOfLiquid;
	private double maxAmountOfLiquid;
	
	/**
	 * Constructor
	 * @param liquidType - liquid type
	 * @param amountOfLiquid - amount of liquid
	 * @param maxAmountOfLiquid - max amount of liquid
	 */
	public Glass(double maxAmountOfLiquid) {
	
		this.liquidType = null;
		this.amountOfLiquid = 0;
		this.maxAmountOfLiquid = maxAmountOfLiquid;
	}
	
	/**
	 * toStirng for printing 
	 */
	public String toString(){
		String s = "";
		
		s += "Liquid type: " + liquidType + "\n";
		s += "Amount of liquid: " + amountOfLiquid + "\n";
		s += "Max amount of liquid: " + maxAmountOfLiquid + "\n";
		return s;
	}
	/**
	 * Get type of liquid
	 * @return - liquid type
	 */
	public String getTypeOfLiquid(){
		return liquidType;
	}
	/**
	 * Set type of liquid
	 * @param type - Set type of liquid
	 */
	public void setTypeOfLiquid(String type){
		this.liquidType = type;
	}
	/**
	 * Get max capacity
	 * @param max - max capacity
	 */
	public void getMaxCapacity(double max){
		this.maxAmountOfLiquid = max;
	}
	/**
	 * Get current capacity
	 * @return
	 */
	public double getCurrentCapacity(){
		return amountOfLiquid;
	}
	/**
	 * Add liquid
	 * @param liquid - liquid to add
	 * @param amountOfLiquid - amount of liquid
	 */
	public void addLiquid(String liquid, int amountOfLiquid){
		// if glass is empty
		if(this.liquidType == null ){
			// add value of String liquid
			this.liquidType = liquid;
			// if amount is less then max capacity add
			if(this.amountOfLiquid + amountOfLiquid < maxAmountOfLiquid){
				this.amountOfLiquid += amountOfLiquid;
			} else{
				// fill the cup up to max
				this.amountOfLiquid = maxAmountOfLiquid;
			}
		// else if liquid is the same
		} else if(this.liquidType.equals(liquid)){
			// if amount is less then max capacity add
			if(this.amountOfLiquid + amountOfLiquid < maxAmountOfLiquid){
				this.amountOfLiquid += amountOfLiquid;
			} else {
				// fill the cup up to max
				this.amountOfLiquid = maxAmountOfLiquid;
			}
		// it liquid isn't same 
		} else {
			System.out.println("You are not allowed to mix liquid.");
		}
		
	}
	/**
	 * Empty glass
	 */
	public void emptyGlass(){
		//set value to zero
		this.amountOfLiquid = 0;
		// set type to null
		this.liquidType = null;
	}
	
	
}
