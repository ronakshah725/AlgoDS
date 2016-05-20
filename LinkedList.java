public class LinkedList{
	
	private Node head;

	/*
		Append a new Node to the tail	 
	*/

	void appendToTail(int d){
		Node n = new Node(d);
		if(head == null){
			head = n;
			return;
		}

		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next  = n;

	}

	/*
		Create a new LinkedList from given int array
	 */

	void newNodeFromArray(int[] arr){

		this.head = new Node(arr[0]);
		Node n = this.head;
		for (int i=1; i<arr.length; i++){
			n.next = new Node(arr[i]);
			n = n.next;
		}
	}

	/*
		Append a new Node to the front or head
	 */

	void appendToFront(int data){
		Node n = new Node(data);
		if (head==null){
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	/*
		Print the LinkedList
	 */

	void printList(){

		System.out.print("LinkedList: ");
		if(head == null){
			System.out.println(" -> ");
			return;
		}
		Node current  = head;
		while(current != null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	/*
		Get the Middle Element
		Trick: 
	 */

	int getMid(){
		if(head == null) return -1;
		if(head.next == null) return head.data;

		Node fast = head;
		Node slow = head;
		while(fast.next!= null){

			if(fast.next.next!= null){
				fast = fast.next.next;
				slow = slow.next;
			}else{
				fast = fast.next;
			}
		}
		return slow.data;
	}

	/*
		Deletes  first occurrences and returns the head
	 */
	
	Node delete(int data){

		//if the first node
		if(head.data == data){
			head = head.next;
			return head;
		}
		//if the middle or last node
		Node prev = head;
		Node current = head.next;

		while(current != null){
			if(current.data == data){
				prev.next = current.next;
				return head;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}

	/*
	 * Delete all occurrences and returns the head
	 */
	
	void deleteAll(int data){

		//Delete all first occurrences
		while(head.data == data){
			head = head.next;
		}
		//if the middle or last node
		Node prev = head;
		Node current = head;
		
		while(current != null){
			if(current.data == data){
				prev.next = current.next;
				
			}
			prev = current;
			current = current.next;
		}
	}


	int length(Node curr){

		if(curr==null)
			return 0;
		return 1+length(curr.next);

	}

	/*
		get the number of nodes in a linkedlist
	 */

	int length(){

		return length(this.head);
	}

	//null
	//1
	//1 2
	//1 2 3
	//1 2 3 4
	
	/*
	reverse a ll
	Logic: 
		1. For each node n, store the next and the prev node
		2. reverse links for n and update 
	 */
	void reverse(){

		if (head==null || (head!=null && head.next==null)) 
			return;									// only 0 or 1 elements
													

		Node n = head;
		Node prev = null; 							//since previous to the first node 
													//will be null in the reversed linkedList
		
		Node next = head;

		while( n != null ){

			next = n.next; 							// store the next node
			n.next = prev; 							// change n's next to previos node
			
			prev = n;	   							// Reversing done now setup for next iter
			n = next;
		}
		this.head = prev;							// Head in previous node

	}


	/*
		Head Getter
	 */

	
	public Node getHead() {
		return head;
	}

	/*
		Head Setter
	 */

	public void setHead(Node head) {
		this.head = head;
	}


	class Node{
		
		int data;
		Node next;

		Node(int data){
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}


	}

}

