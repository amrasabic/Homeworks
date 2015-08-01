package ba.bitcamp.homeworkSortedIntList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		SortedIntList list = new SortedIntList();

		while (true) {
			try {
				System.out.println("Insert positive numbers: ");
				int number = in.nextInt();
				if (number > 0) {
					list.add(number);
				} else {
					break;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Input should be a number. Or insert negative number to stop.");
				in.nextLine();
			}
		}

		System.out.println("Number entered: " + list);
		System.out.println("Array: " + Arrays.toString(list.toArray()));
		System.out.println("Size of an array: " + list.getLength());

		in.close();

	}

}
