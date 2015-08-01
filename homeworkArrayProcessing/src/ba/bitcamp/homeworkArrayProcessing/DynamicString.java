package ba.bitcamp.homeworkArrayProcessing;

public class DynamicString {

	// declaration of parameters
	private String myArray[];
	private int count;
	
	/**
	 * Constructor
	 * @param n - number of element
	 * @param value - value of element
	 */
	public DynamicString(int n, String value) {
		super();
		myArray = new String[n];
		count = n;
		
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = value;
		}
	}
	
	/**
	 * Constructor
	 * @param n - number of element
	 */
	public DynamicString(int n) {
		this(n, null);
		count = 0;
	}
	
	/**
	 * Empty constructor.
	 */
	public DynamicString() {
		this(8);
	}

	/**
	 * Add element in array
	 * @param element - element to add to array
	 */
	public void addElement(String element) {
		
		if (count >= myArray.length) {
			String temp[] = myArray;
			myArray = new String[myArray.length * 2 + 1];

			for (int i = 0; i < temp.length; i++) {
				myArray[i] = temp[i];
			}

			myArray[count] = element;
			count++;
			
		} else if (count < myArray.length) {
			myArray[count] = element;
			count++;
		}
	}

	/**
	 * Add an array of elements
	 * @param array - array to add
	 */
	public void addArrayOfElements(String[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
	}

	/**
	 * Size
	 * <p>
	 * Size of an array.
	 * @return - int value for numbers in array
	 */
	public int size() {
		return count;
	}

	/**
	 * Total size
	 * <p>
	 * Number of elements in array.
	 * @return - number of elements in array
	 */
	public int totalSize() {
		return myArray.length;
	}

	/**
	 * to String method for printing an array
	 */
	public String toString() {
		
		String str = "";
		
		if (count > 0) {
			str += size() + "\t[ ";
			for (int i = 0; i < count - 1; i++) {
				str += myArray[i] + ", ";
			}

			str += myArray[count - 1] + " ]\n" + totalSize() + "\t[ ";

			for (int i = 0; i < myArray.length - 1; i++) {
				str += myArray[i] + ", ";
			}
			str += myArray[myArray.length - 1] + " ]";
		} else {
			str += size() + "\t[]";
		}
		return str;
	}

	/**
	 * Remove method
	 * @param offset - 
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int offset) throws IndexOutOfBoundsException {
		
		if (count == 0 || offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		myArray[offset] = myArray[count - 1];
		count--;
	}

	/**
	 * Removes the element with inputed index from the array and moving all
	 * elements in the array for one place.
	 * 
	 * @param offset
	 *            - Number of index of element that is needed to be removed.
	 * @throws IndexOutOfBoundsException
	 *             If the inputed index does not exist in array throws
	 *             exception.
	 */
	public void removeSlow(int offset) throws IndexOutOfBoundsException {

		// If there is no elements in the array that have value throws
		// exception.
		if (count == 0) {
			throw new IndexOutOfBoundsException();
		}

		// If the inputed index does not exist in array throws exception.
		if (offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		// Creating new array.
		String[] tmp = new String[myArray.length];

		// Putting all elements of the array in the new array except the element
		// that is needed to be removed and decreasing number of elements for
		// one.
		for (int i = 0; i < tmp.length - 1; i++) {
			if (i == offset) {
				tmp[i] = myArray[++offset];
			} else {
				tmp[i] = myArray[offset];
			}
			offset++;
		}
		myArray = tmp;
		count--;
		myArray[count] = myArray[count - 1];

		// If the number of elements in the array is three times larger than
		// number of elements that have value, than decreasing the number of
		// elements in the array for half.
		if (count <= myArray.length / 3) {
			String[] temp = new String[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = myArray[i];
			}
			myArray = temp;
		}
	}

	/*
	 * Get and set methods.
	 */
	public String[] getMyArray() {
		return myArray;
	}

	public void setMyArray(String[] myArray) {
		this.myArray = myArray;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}