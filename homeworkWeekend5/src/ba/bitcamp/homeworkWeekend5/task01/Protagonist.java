package ba.bitcamp.homeworkWeekend5.task01;

/**
 * Describes the main good guy in the story
 * 
 * @author amra.sabic
 *
 */
public class Protagonist extends Character {
	// declaration of parameters
	private static int hasHelpers = 0;

	private Goal goal;
	private Character[] helpers = new Character[3];
	private Character antagonist;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - story name
	 * @param gender
	 *            - char gender
	 * @param isCapable
	 *            - skill, two conditions: capable and incapable
	 * @param goal
	 *            - the goal of a single character in the plot of a story
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

	public void setGoal(Goal goal) {
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
	public void setHelpers(Character[] helpers)
			throws IndexOutOfBoundsException {

		if (helpers.length > this.helpers.length) {
			throw new IndexOutOfBoundsException(
					"There are already three helpers.");
		} else {
			this.helpers = helpers;
		}

	}

	public void addCharacter(Character helper) throws IndexOutOfBoundsException {

		if (hasHelpers == helpers.length) {
			throw new IndexOutOfBoundsException(
					"There is already max number of helpers.");
		} else if (hasHelpers < helpers.length) {
			for (int i = 0; i < helpers.length; i++) {
				if (helpers[i] == null) {
					helpers[i] = helper;
					break;
				}
			}
			hasHelpers++;
		}
	}

	public void attainGoal() {
		// Set chances to 0
		int odds = 0;
		// check out if main character is alive
		if (this.isAlive() == true) {
			// if character is capable increase odds by 40
			if (this.isCapable() == Character.CAPABLE) {
				odds += 40;
			}
			// for loop through helpers
			// every helper that is capable chances to win increase for 20%
			for (int i = 0; i < helpers.length; i++) {
				if (helpers[i].isCapable() == Character.CAPABLE) {
					odds += 20;
				}
			}
			// if antagonist is capable decrease chances to win for 30%
			if (antagonist.isCapable() == Character.INCAPABLE) {
				odds -= 30;
			}
			// if level of difficulty is impossible chance to win is decrease for 100%
			if (goal.getDifficulty() == Goal.IMPOSSIBLE) {
				odds -= 100;
			}
			// if level of difficulty is difficult chances  to win is decrease for 20%
			if (goal.getDifficulty() == Goal.DIFFICULT) {
				odds -= 20;
			}
			// no negative values, set to zero
			if (odds < 0) {
				odds = 0;
			}

			// if chances are 50% or higher main character wins
			if (odds >= 50) {
				System.out.println("Character defeated antagonist in battle to "
						+ goal.name + ".");
				for (int i = 0; i < helpers.length; i++) {
					if (helpers[i].isCapable() == Character.INCAPABLE) {
						helpers[i].setIsCapable();
						break;
					}
				}
				// if chances are less than 50% main character won't win
			} else {
				System.out.println("Character didn't defeat antagonist in battle to "
						+ goal.name + ".");
				helpers[(int)(Math.random() * 2)].killChar();
				
				for (int i = 0; i < helpers.length; i++) {
					if (helpers[i].isCapable() == INCAPABLE) {
						if (helpers[i].isAlive() == true) {
							helpers[i].setIsCapable();
							break;
						}
					}
				}
			}
		}
	}

}
