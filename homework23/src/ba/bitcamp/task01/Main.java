package ba.bitcamp.task01;

public class Main {

	public static void main(String[] args) {

		StackString stack = new StackString();

		stack.push("first");
		stack.push("second");

		System.out.println(stack.isEmpty());
		System.out.println(stack);

		System.out.println(stack.peek());

		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());

		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			stack.push("Ajla" + i);
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
