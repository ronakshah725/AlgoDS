import java.util.*;

public class LinkedList {

	private Node head;

	/*
	 * Head Getter
	 */

	public Node getHead() {

		return head;
	}

	/*
	 * Head Setter
	 */

	public void setHead(Node head) {

		this.head = head;
	}

	class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	/**************** LIST HELPERS *************************/

	/*
	 * Append a new Node to the tail
	 */

	void appendToTail(int d) {
		Node n = new Node(d);
		if (head == null) {
			head = n;
			return;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = n;
	}

	/*
	 * Create a new LinkedList from given int array
	 */

	void newNodeFromArray(int[] arr) {

		this.head = new Node(arr[0]);
		Node n = this.head;
		for (int i = 1; i < arr.length; i++) {
			n.next = new Node(arr[i]);
			n = n.next;
		}
	}

	/*
	 * Append a new Node to the front or head
	 */

	void appendToFront(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	/*
	 * Print the LinkedList
	 */

	void printList() {

		System.out.print("LinkedList: ");
		if (head == null) {
			System.out.println(" -> ");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	int length(Node curr) {

		if (curr == null)
			return 0;
		return 1 + length(curr.next);
	}

	/*
	 * get the number of nodes in a linkedlist
	 */

	int length() {

		return length(this.head);
	}

	/**************** LIST DS ALGO *************************/

	/*
	 * 1. Get the Middle Element Trick:
	 */

	int getMid() {
		if (head == null)
			return -1;
		if (head.next == null)
			return head.data;

		Node fast = head;
		Node slow = head;
		while (fast.next != null) {

			if (fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			} else {
				fast = fast.next;
			}
		}
		return slow.data;
	}

	/*
	 * 2. Deletes first occurrences and returns the head Boundary: 1. Handle
	 * delete from heads seperately
	 */

	Node delete(int data) {

		// if the first node
		if (head.data == data) {
			head = head.next;
			return head;
		}
		// if the middle or last node
		Node prev = head;
		Node current = head.next;

		while (current != null) {
			if (current.data == data) {
				prev.next = current.next;
				return head;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}

	/*
	 * 3. Delete all occurrences and returns the head
	 */

	void deleteAll(int data) {

		// Delete all first occurrences
		while (head.data == data) {
			head = head.next;
		}
		// if the middle or last node
		Node prev = head;
		Node current = head;

		while (current != null) {
			if (current.data == data) {
				prev.next = current.next;

			}
			prev = current;
			current = current.next;
		}
	}

	/*
	 * 4. reverse all Logic: 1. For each node n, store the next and the prev
	 * node 2. reverse links for n and update Boundary: 1. One or element array
	 */
	void reverse() {

		if (head == null || head.next == null)
			return; // only 0 or 1 elements

		Node n = head;
		Node prev = null; // since previous to the first node will be null in the reversed linkedList

		Node next = head;

		while (n != null) {

			next = n.next; // store the next node
			n.next = prev; // change n's next to previos node

			prev = n; // Reversing done now setup for next iter
			n = next;
		}
		this.head = prev; // Head in previous node
	}

	/*
	 * 5. Remove Duplicates Logic: 1. O(n) time, O(n) space, hashTable 2.
	 * prev and n, move prev ahead only if found a non dup element, else, prev
	 */

	// 1
	// 1 1
	// 1 2 1
	// 1 2 1 4
	void removeDups() {

		Set<Integer> set = new HashSet<>();
		Node n = head;
		Node prev = head;

		while (n != null) {
			if (!set.contains(n.data)) {
				set.add(n.data);
				prev = n;

			} else {
				prev.next = n.next;
			}
			n = n.next;

		}

	}

/*
	6. Delete middle node, given the node
		middle here means any except first or last
		a -> n-> c -> d
		input: n
		output: nothing but new list becomes a->c->d
		Logic: reference of n is given, so the a.next points to this reference, 
		let  
			n.data = n.next.data //store c's data in n's ,coz removing n
			n.next (ie. c) = n.next.next;



 */

		void removeMidNode(Node n){
			if(n == null || n.next == null || n == head) //cant be a null, or last or first node
				return;
			n.data = n.next.data;
			n.next = n.next.next;

		}



}
