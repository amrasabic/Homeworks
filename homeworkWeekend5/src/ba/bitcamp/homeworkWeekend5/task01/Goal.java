package ba.bitcamp.homeworkWeekend5.task01;
/**
 * Describes the goal of a single character in the plot of a story
 * @author amra.sabic
 *
 */
public class Goal extends StoryElement{

	static final int EASY = 0;
	static final int DIFFICULT = 1;
	static final int IMPOSSIBLE = 2;
	
	protected String name;
	private int difficulty;
	private String event;
	private Character toWho;
	
	/**
	 * Constructor
	 * @param goal - goal of the single character
	 * @param weight - goal difficulty
	 * @param whatWillHappen - event that will occur
	 * @param toWho - character who will be affected by this event
	 */
	public Goal(String name, int difficulty, String event, Character toWho) {

		this.name = name;
		this.difficulty = difficulty;
		this.event = event;
		this.toWho = toWho;
	}

	// getters
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public String getEvent() {
		return event;
	}

	public Character getToWho() {
		return toWho;
	}

}
