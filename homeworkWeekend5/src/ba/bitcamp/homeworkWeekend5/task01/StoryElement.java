package ba.bitcamp.homeworkWeekend5.task01;

/**
 * Describes an element in the plot of a story
 * 
 * @author amra.sabic
 */
public abstract class StoryElement {
	// declaration of parameters
	private String name;

	/**
	 * Constructor
	 * @param name - Story name
	 */
	public StoryElement(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Constructor with default value
	 */
	public StoryElement() {
		super();
		this.name = "STElement";
	}

	public String getName() {
		return this.name;
	}
}
