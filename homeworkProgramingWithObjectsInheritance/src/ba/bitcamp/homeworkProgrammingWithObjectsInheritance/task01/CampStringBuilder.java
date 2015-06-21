package ba.bitcamp.homeworkProgrammingWithObjectsInheritance.task01;


/**
 * 
 * @author amra.sabic
 *
 */
public class CampStringBuilder {
	// declaration of parameters
	private char[] characters;

	/**
	 * Constructor - empty (no parameters)
	 */
	public CampStringBuilder() {
		super();
		this.characters = new char[0];
	}
	/**
	 * Constructor
	 * @param characters - array of characters
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}
	/**
	 * Append
	 * <p>
	 * Adds the string into an array of characters at the end.
	 * @param o - object            
	 */
	public void append(Object o) {
		String common = String.valueOf(this.characters) + " " + o.toString();
		this.characters = common.toCharArray();
	}
	/**
	 * Prepend
	 * <p>
	 * Adds the inserted string in front of an array of characters.
	  * @param o - object
	 */
	public void prepend(Object o) {
		String common = o.toString() + " " + String.valueOf(this.characters);
		this.characters = common.toCharArray();
	}

	/**
	 * to String method for printing out the class above
	 */
	public String toString() {
		return String.valueOf(this.characters);
	}
}