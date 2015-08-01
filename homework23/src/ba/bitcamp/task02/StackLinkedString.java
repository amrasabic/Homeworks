package ba.bitcamp.task02;

import java.util.EmptyStackException;


public class StackLinkedString {

	private Node head;
	
	public StackLinkedString() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public String push(String value) {
		if (head == null) {
			head = new Node(value);
		} else {
			Node tmp = new Node(value);
			tmp.setNext(head);
			head = tmp;
		}
		return value;
	}
	
	public String peek() {
		return head.getValue();
	}
	
	public String pop() {
		if(head == null){
			throw new EmptyStackException();
		}
		
		String tmp = head.getValue();
		head = head.getNext();
		return tmp;
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
	
	
	public String toString() {
		if(head == null) {
			return "Stack is empty!";
		}else{
			return head.toString();
		}
	}
		
	private class Node {
		
		private String value;
		private Node next;
		
		public Node(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public String toString() {
			if(next == null) {
				return value + " ";
			} else {
				return value + " " + next.toString();
			}
		}
	}
}
