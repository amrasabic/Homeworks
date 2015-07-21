package ba.bitcamp.homework.part02.task02;

import ba.bitcamp.homework.part01.task01.Computer;

public class ArrayManipulation {
	
	/**
	 * Extend array using System.arraycopy()
	 * @param c - array of computers
	 * @return - extended array of computers by 1
	 */
	public static Computer[] extendArray(Computer[] c){
		// temporary array
		Computer[] tmp = new Computer[c.length + 1]; 
		System.arraycopy(c, 0, tmp, 0, c.length);
		return tmp;
	}
	/**
	 * Shrink array using System.arraycopy()
	 * @param c - array of computers
	 * @param index - index of element of array (the one to remove)
	 * @return
	 */
	public static Computer[] shrinkArray(Computer[] c, int index){
		// temporary array
		Computer[] tmp = new Computer[c.length - 1]; 
		System.arraycopy(c, 0, tmp, 0, index);
		System.arraycopy(c, index+1, tmp, index, c.length - index - 1);
		return tmp;
	}
}
