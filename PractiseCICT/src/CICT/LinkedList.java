

import java.util.*;

public class LinkedList {
	public boolean DEBUG = false;
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

	public class Node {

		public int data;
		public Node next;

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

	public void appendToTail(int d) {
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
	 	Append a new Node to the tail
	 */

	public void appendToTail(Node n) {
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

	public  void newNodeFromArray(int[] arr) {

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

	public void appendToFront(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	/*
	 * Append a new Node to the front or head
	 */

	public void appendToFront(Node n) {
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

	public void printList() {

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

	public void printList(String msg, Node head) {

		System.out.print(msg);
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

	public int length(Node curr) {

		if (curr == null)
			return 0;
		return 1 + length(curr.next);
	}

	/*
	 * get the number of nodes in a linkedlist
	 */

	public int length() {

		return length(this.head);
	}

	/**************** LIST DS ALGO *************************/

	 /*
	 * 1. Get the Middle Element Trick:
	 */

	// 
	// 1->2
	// 1->2->1  
	// 1->2->2->1
	// 1->2->3->4->3->2->1
	// 1->2->3->3->2->1
	// 
	
	public Node getMid(){

		if(head == null || head.next ==null)
			return head;

		Node fast = head;
		Node slow = head;

		while(fast.next!= null){
			if(fast.next.next != null ){
				fast = fast.next.next;
				slow = slow.next;

			}else{
				break;
			}

		} 

		return slow;
	}

	/*
	 * 2. Deletes first occurrences and returns the head Boundary: 1. Handle
	 * delete from heads seperately
	 */

	public Node delete(int data) {

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

	public void deleteAll(int data) {

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
	public void reverse() {

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

	public void removeDups() {

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

	public void removeMidNode(Node n){
			if(n == null || n.next == null || n == head) //cant be a null, or last or first node
				return;
			n.data = n.next.data;
			n.next = n.next.next;
	}


	/*
	
		7. kth to last element
		1->2->3->4->
		input: 2
		output: 3
		
		1->2->3->4->5->
		input: 2
		output: 4
		
		Logic: 
		1.Two pointers, n and offset
		2.Move offset k positions
		3.Then move n till offset reacges end
	 */

	public Node kthToLast(int k){
		if(head == null ) return null;
		if(head.next == null ) {
			return head;}
		Node n = head;
		Node offset = head;
		while(k > 0){
			offset = offset.next;
			k--;

		}

		while(offset.next!=null){
			n =n.next;
			offset = offset.next;

		}
		return n;
	}

	/*
	
		6. partition around given valvue v
		   Such thatAll less than v on left, all greater than equal to v on right
		   Input : 11->7->2->3->-5->6, v = 5
		   Output : 2-3->5->6->11->7
		   Logic 1: if node.data< v remove node and add to head
	 */
//1
//3 1 (v=2)
//3 1 2 6 5 (v=4)
//	  p n
//1 3 2 6
//4 3 2 1 v=2
	public void partition(int v){
		if(head ==null || head.next == null){
			return ;
		}

		Node n = head, prev = head;
		while( n!= null){
			if(n.data < v){
				if(n == head) {
					n = n.next;
					continue;
				}
				prev.next = n.next;
				this.appendToFront(n.data);
			}
			else{
				prev = n;
			}
			n = n.next;
		}
	}	 



	/*
	7. isPalindrome()
	Technique 1:
		Logic:	a -> ... -> x -> ... l 
		1. find mid, x
		2. reverse from  mid, l->x  
		3. compare both a->x-1, l->x-1
		4. stitch both together

		Glitches:
		1. Dont want to include the mid node if length is odd abcba when comparing the two strings
		2. For even: [abba] l1: ab, l2: ba 
		3. For odd: [abcba] l1: abc, l2: ba

	Technique 2:
	Stack based
	1. Reach till mid with fast slow
	2. Add elements from mid.next into a stack till u reach end
	3. Now compare og list head and stack top to equality
	4. Do unitl no elements in the stack


	 */
	
	//	og							n1		 	n2			rev n2			
	//	1 1							1			1			1
	//	1 2 2 1						1 2        	2 1			1 2
	//	3 2 1 2 3					3 2 1      	2 3			3 2
	//	1 2 3 4 4 3 2 1				1 2 3 4    	4 3 2 1		1 2 3 4
	
	public boolean isPalindrome(){

		boolean isPalin = true;						// Need for the flag: if instead of setting the flag,
														// you return straight, when LL is not a palindrome, 
														// stitching is not done coz returns with false,

														//return if 0 or 1 elements
		if(head == null || head.next ==null)
			return isPalin;

		//*** 1. get mid
		
		Node mid = getMid();							// 1->2, returns 1
														// 1->2->1, returns 2  
														// 1->2->2->1, returns first 2
		if(DEBUG){
			println("1. Mid: " + mid.data);
			this.printList("l2 before rev: ", mid.next);
		}

		
		//*** 2. reversed l2 
		
		Node l2RevHead = reverseAndGetHead(mid.next); 	// dont include mid in the new list l2
		

		mid.next = null; 								//to mark end of l1
														//l1 heah is this.head

		if (DEBUG){								
			this.printList("l1 :", this.head);
			this.printList("l2: ", l2RevHead);
		}
	
		//*** 3. compare l1 and l2 s elements
		
		Node n1 = head;
		Node n2 = l2RevHead;

		while(n2!=null ){
			if(n2.data != n1.data){
				if(DEBUG){
					println(n1.data + "--n1 n2--" + n2.data);
				}

				isPalin = false;
				
			}

			if(n1.next != null)							//Go till last element only, dont nullify n1, 
				n1 = n1.next;							//need n1 for stitching
				
			n2 = n2.next;
		}

		//*** 4. Stitch back the list, n1 is already at its end, append n2 elems to n1
		
		n2 = reverseAndGetHead(l2RevHead);
		while(n2!=null){
			n1.next = n2;
			n1 = n1.next;
			n2 = n2.next;
		}

		return isPalin;
	}
	


	Node reverseAndGetHead(Node head){

		if(head == null || head.next == null)
			return head;

		Node n = head, prev = null, next = head;

		while ( n != null ){

			next = n.next;
			n.next = prev;

			prev = n;
			n = next;
		}
		return prev; 							// new head;
	}

	/*
	
		8. Sort a Linked List of 0s, 1s and 2s
		Given a Singly linked list with each node containing either 0, 1 or 2. Write code to sort the list.
		Input : 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> 0
		Output : 0 -> 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2

		Solution:
		You can do that in O(n).

		/*
		
			Traverse the linked list from the beginning and count the number of 0s, 1s and 2s. (Let the counts be p, q, r)
			Now traverse the linked list again and set first p nodes to 0, q nodes to 1 and r nodes to 2.
	
	*/
	 
	 
	
	public void sortLLWithOnly0s_1s_2s(){

		if (head == null || head.next == null)
			return ;
		
		int zeros = 0, ones = 0, twos = 0;

		Node n = head;

		while(n != null){

			if(n.data == 0)
				zeros++;
			else if(n.data == 1)
				ones++;
			else
				twos++;
			n = n.next;
		}
		n = head;   //0 2 1  2 2 1 0 1 1
		while(true){
			if(--zeros >= 0)
				n.data = 0;
			else if( --ones >= 0 )
				n.data = 1;
			else if( --twos >= 0)
				n.data = 2;
			else
				break;
			n = n.next;

		}
	}


////TODO
/*	// 9. Add 327 + 789 , given both as reversed lists
	// 
	// 1 2 3
	// 9 8 7
	// 
	// 1 2
	// 9 8 7
	// 
	// 1 2 3
	// 9 8
	// 
	Node sumTwoLLReverse(Node h1, Node h2){

		int carry = 0;
		Node n1 = h1, n2 = h2;
		int sum = 0;

		Node sumNode = null;
		Node sumHead = sumNode;
		while(n1!=null || n2 != null){
			println("wsd");
			// n1 dig exhausted
			if(n1==null){
				sum = n2.data + carry;
				println("n1 null");

			}
			// n2 exhausted
			else if(n2 == null){
				sum = n1.data + carry;
				println("n2 null");

			}
			// both there
			else{
				sum = n1.data + n2.data + carry;
				println("both there = " + sum);

			}

			//Manage carry
			if(sum/10>0)
				carry = 1;
			else{
				carry = 0;
			}

			//Make new Node
			Node n = new Node(sum%10);
			if(sumNode == null){
				sumNode = n;
			}else{
			sumNode.next = n;
			sumNode = sumNode.next;
			}
			n1 = n1.next;
			n2 = n2.next;
			this.printList("Current Sum: ",  sumHead);
		}
		return sumHead;
	}*/

	/*
	
		10. Check if two linkedLists intersect by reference
		
		1-2-3 \
				6 - 2 - 3
		  4-5 /
		Here 6 is the intersecting node, return it
		Logic 1:
		1. find lengths and store tail of both (if tail1!=tail2, no collission, return false asap) 
		2. chop off the bigger list from the head to match bigger.length = smaller.length
		3. Loop both together and return true if you get a collission when bigger == smaller
		4.

	 */
	
	public Node intersection(Node h2){

		if(this.head == null || h2 == null)
			return null;
		
		Node n1 = head;
		Node n2 = h2;

		//get the length of both the lists
		int l1 = length();
		this.head = h2;
		int l2 = length();
		this.head = n1;

		//find the bigger list
		Node bigger = null;
		Node smaller = null;
		int diff = l2 - l1;

		if(l2>l1){
			bigger = n2;
			smaller = n1;
		}else{
			bigger = n1;
			smaller = n2;
			diff = -diff;
		}

		if(DEBUG){
			println("Diff : " + diff);
		}

		//chop off bigger lls extra nodes
		while(--diff >= 0){
			bigger = bigger.next;
		}

		//find the collissiojn
		while(bigger!=null){
			if(bigger == smaller){
				return bigger;
			}
			bigger = bigger.next;
			smaller = smaller.next;
		}
		return null;
	}


	static public void println(Object a){
		System.out.println((String)a);
	}

	static public void print(Object a){
		System.out.print((String)a);
	}


}
