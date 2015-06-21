package ba.bitcamp.homeworkProgrammingWithObjectsInheritance.task01;

public class Main {

	public static void main(String[] args) {
		
		CampStringBuilder cp = new CampStringBuilder();
		
		cp.append("drugi");
		cp.prepend("prvi");
		cp.append("treci");
		cp.prepend("nulti");
		
		System.out.println(cp.toString());
	}
}
