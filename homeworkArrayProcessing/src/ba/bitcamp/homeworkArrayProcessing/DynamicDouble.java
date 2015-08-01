package ba.bitcamp.homeworkArrayProcessing;

public class DynamicDouble {

	// declaration of parameters
	private double myArray[];
	private int count;

	/**
	 * Constructor
	 * @param n - number of element
	 * @param value - value of element
	 */
	public DynamicDouble(int n, double value) {
		super();
		myArray = new double[n];
		count = n;
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = value;
		}
	}

	/**
	 * Constructor
	 * @param n - number of element
	 */
	public DynamicDouble(int n) {
		this(n, 0.0);
		count = 0;
	}

	/**
	 * Empty constructor.
	 */
	public DynamicDouble() {
		this(8);
	}

	/**
	 * Add element in array
	 * @param element - element to add to array
	 */
	public void addElement(double element) {
		
		if (count >= myArray.length) {
			double temp[] = myArray;
			myArray = new double[myArray.length * 2 + 1];

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
	public void addArrayOfElements(double[] array) {
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
		
		String s = size() + "\t[ ";
		for (int i = 0; i < count; i++) {
			s += myArray[i] + " ";
		}

		s += "]\n" + totalSize() + "\t[ ";
		for (int i = 0; i < myArray.length; i++) {
			s += myArray[i] + " ";
		}
		s += "]";
		return s;
	}
	
	/**
	 * Remove method
	 * @param offset - 
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int offset) throws IndexOutOfBoundsException {

		// throws exception if an array is empty or index isn't in array
		if (count == 0 || offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		double[] tmp = new double[myArray.length];

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
	}

	// getters and setters
	public double[] getMyArray() {
		return myArray;
	}

	public void setMyArray(double[] myArray) {
		this.myArray = myArray;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}