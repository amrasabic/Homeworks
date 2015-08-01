package ba.bitcamp.task01;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackString {

	private String[] array;

	public StackString() {
		this.array = new String[0];
	}

	public boolean isEmpty() {
		return (array.length == 0);
	}

	public String push(String value) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return value;
	}

	public String pop() throws EmptyStackException {
		if (array.length > 0) {
			String tmp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);
			return tmp;
		} else {
			throw new EmptyStackException();
		}
	}

	public String peek() throws EmptyStackException {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the
	 * object o occurs as an item in this stack, this method returns the
	 * distance from the top of the stack of the occurrence nearest the top of
	 * the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare o to the items in this stack.
	 * 
	 * @param value
	 * @return
	 */

	public int search(String value){
		int counter = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			counter++;
			 if(array[i].equals(value)){
				 return counter;
			 }
		}
		return -1;
		
	}

	public String toString() {
		return Arrays.toString(array);
	}
}
