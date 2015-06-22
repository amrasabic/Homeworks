package ba.bitcamp.homeworkWeekend5.task01;
/**
 * Describes the main good guy in the story
 * @author amra.sabic
 *
 */
public class Protagonist extends Character {
	// declaration of parameters
	private static final int MAX_CHARACTERS = 3;
	
	private Goal goal;
	private Character[] helpers = new Character[3];
	private Character antagonist;
	
	/**
	 * Constructor
	 * @param name - story name
	 * @param gender - char gender
	 * @param isCapable - skill, two conditions: capable and incapable
	 * @param goal - the goal of a single character in the plot of a story
	 */
	public Protagonist(String name, int gender, int isCapable, Goal main) {
		super(name, gender, isCapable);
		this.goal = main;
		this.antagonist = null;
	}
	
	// getters and setters
	
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal){
		this.goal = goal;
	}
	
	public Character getAntagonist() {
		return antagonist;
	}


	public Character[] getHelpers() {
		return helpers;
	}

	public void setAntagonist(Character antagonist) {
		this.antagonist = antagonist;
	}
	
	/**
	 * Set helpers
	 * <p>
	 * 
	 * @param helpers
	 * @throws IndexOutOfBoundsException
	 */
	public void setHelpers(Character[] helpers) throws IndexOutOfBoundsException {
		
		if(helpers.length > this.helpers.length){
			throw new IndexOutOfBoundsException("There are already three helpers.");
		} else {
			this.helpers = helpers;
		}
		
	}


	public void addCharacter(Character helper) throws IndexOutOfBoundsException {
		
				// TO BE CONTINUED

	}
	
}
