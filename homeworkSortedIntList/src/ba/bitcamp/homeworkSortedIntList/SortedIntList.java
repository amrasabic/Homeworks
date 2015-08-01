package ba.bitcamp.homeworkSortedIntList;

/**
 * @author amra.sabic
 */
public class SortedIntList {

	// declaration of parameters
	private Node start;
	private int count;

	/**
	 * Constructor
	 */
	public SortedIntList() {
		this.start = null;
		this.count = 0;
	}

	/**
	 * Empty method
	 * 
	 * @return - boolean value true list doesn't contain elements, else return false
	 */
	public boolean empty() {
		return start == null;
	}

	/**
	 * Get length
	 * 
	 * @return - length of the list
	 */
	public int getLength() {
		return count;
	}

	/**
	 * Add element
	 * 
	 * @param value - element to add to list
	 */
	public void add(int value) {
		boolean isLarger = true;

		Node newNode = new Node(value);
		if (start == null) {
			start = newNode;
		} else if (start.getValue() > value) {
			newNode.setNext(start);
			start = newNode;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				if (temp.getNext().getValue() >= value) {
					temp = temp.getNext();
					isLarger = false;
					break;
				} else {
					temp = temp.getNext();
				}
			}
			if (!isLarger) {
				Node previous = getPrevious(temp);
				previous.setNext(newNode);
				newNode.setNext(temp);
			} else {
				temp.setNext(newNode);
			}
		}
		count++;
	}

	/**
	 * Get previous node
	 * 
	 * @param node - relative to this node
	 * @return - returns the node that is previous from inputed node
	 */
	private Node getPrevious(Node node) {
		if (node == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != node) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Get node on forwarded index
	 * @param index - of the node.
	 * @return Node - value of that index
	 */
	public int get(int index) {
		if (start == null) {
			return -1;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getValue();
		}
	}

	public int[] toArray() {
		int[] array = new int[count];
		for (int i = 0; i < array.length; i++) {
			array[i] = this.get(i);
		}
		return array;
	}

	/**
	 * toString for printing
	 */
	public String toString() {
		if (start == null) {
			return "The list is empty.";
		}
		return start.toString();
	}

	/**
	 * Inner class
	 * 
	 * @author amra.sabic
	 */
	private class Node {
		private int value;
		private Node next;

		/**
		 * Constructor
		 * 
		 */
		public Node(int value) {
			super();
			this.value = value;
		}

		/**
		 * toString for printing
		 */
		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + ", " + next.toString();
		}

		// getters and setters
		public int getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}