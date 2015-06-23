package ba.bitcamp.homeworkWeekend5.task01;

/**
 * Describes one of the characters in the plot of a story
 * 
 * @author amra.sabic
 */
public class Character extends StoryElement {
	// declaration of parameters
	protected static final int FEMALE = 0;
	protected static final int MALE = 1;
	protected static final int CAPABLE = 0;
	protected static final int INCAPABLE = 1;

	private int gender;
	private boolean isAlive;
	private int isCapable;

	/**
	 * Constructor
	 * 
	 * @param name - name of the story from extended class
	 * @param gender - gender of character
	 * @param isCapable - skill, two conditions: capable and incapable
	 */
	public Character(String name, int gender, int isCapable) {
		super(name);
		this.gender = gender;
		this.isAlive = true;
		this.isCapable = isCapable;
	}

	// getters and setters
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int isCapable() {
		return isCapable;
	}

	public void setIsCapable() {
		this.isCapable = CAPABLE;
	}


	/**
	 * Disable character
	 * <p>
	 * Sets skill to incapable condition.
	 * 
	 * @param character - character to disable
	 */
	public void disableChar() {

			isCapable = INCAPABLE;
	}
	
	/**
	 * Kill character
	 * <p>
	 * If value of boolean is true set it to false.
	 * 
	 * @param character - character to kill
	 */
	public void killChar() {

			isAlive = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Character other = (Character) obj;
		if (gender != other.gender) {
			return false;
		}
		if (isAlive != other.isAlive) {
			return false;
		}
		if (isCapable != other.isCapable) {
			return false;
		}
		return true;
	}
	
}
