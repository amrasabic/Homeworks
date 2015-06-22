package ba.bitcamp.homeworkWeekend5.task01;
/**
 * Describes the goal of a single character in the plot of a story
 * @author amra.sabic
 *
 */
public class Goal extends StoryElement{

	private static final int EASY = 0;
	private static final int DIFFICULT = 1;
	private static final int IMPOSSIBLE = 2;
	
	private String goal;
	private int difficulty;
	private int event;
	private Character toWho;
	
	/**
	 * Constructor
	 * @param goal - goal of the single character
	 * @param weight - goal difficulty
	 * @param whatWillHappen - event that will occur
	 * @param toWho - character who will be affected by this event
	 */
	public Goal(String goal, int difficulty, int event, Character toWho) {

		this.goal = goal;
		this.difficulty = difficulty;
		this.event = event;
		this.toWho = toWho;
	}

	// getters
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public int getEvent() {
		return event;
	}

	public Character getToWho() {
		return toWho;
	}

}
