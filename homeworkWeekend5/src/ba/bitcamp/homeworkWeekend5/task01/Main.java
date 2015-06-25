package ba.bitcamp.homeworkWeekend5.task01;

public class Main {

	public static void main(String[] args) {
		
		// goal is to defeat evil 
		Goal g1 = new Goal("Defeat the Necromancer", Goal.DIFFICULT, null, null);
		// main character is greatest wizard Gandalf
		Protagonist gandalf = new Protagonist("Gandalf", Character.MALE, Character.CAPABLE, g1);
		// bestest friends of Gandalf and his allys are Elrond and lady Galadriel
		Character elrond = new Character("Elrond", Character.MALE , Character.CAPABLE);
		Character galadriel = new Character("Lady Galadriel", Character.FEMALE, Character.CAPABLE);
		Character saruman = new Character("Saruman the White", Character.MALE , Character.CAPABLE);
		Character[] allys = {elrond, galadriel, saruman};
		// Gandalfs allys to aid him in any battle are both of them
		gandalf.setHelpers(allys);
		// evil, well you guessed it right is the Necromancer
		Character necromancer = new Character("The Necromancer", Character.MALE , Character.CAPABLE);
		// and little reminder that Gandalf is a really capable wizard, not just for fireworks
		gandalf.setIsCapable();
		// and his eternal enemy is Necromancer or any source of evil
		gandalf.setAntagonist(necromancer);
		// so we choose to fight !
		int firstEvent = Event.REVENGE;
		
		gandalf.attainGoal();
		
	}

}
