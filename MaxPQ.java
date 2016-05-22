/*
Binary Heap:
-	Complete Binary tree, only bottom level not balanced, 
	all the leaves stick to the left side
-	Height = Floor[log N], where N is the number of nodes
- 	Array reprststn, starting from a[1], a[0] is unused, to maintain tree access with formulas
-	For k
		 Parent: 	k/2
		 Children:	2k, 2k+1
- 	max heap property: parent is atleast as big as the children
-	Swim: U move up in life upto certain level
- 	Sink: Parent not big enough, push him down. Better or bigger subordinat promoted

********* Additional Info:
- 	Immutability of keys.
	・Assumption: client does not change keys while they're on the PQ.
	・Best practice: use immutable keys.

- 	Minimum-oriented priority queue.
	・Replace less() with greater().
	・Implement greater()
- 	HeapSort	

 */

class MaxPQ<Key extends Comparable<Key>>{
	private static final int DEFAULT_CAPACITY = 50;
	private int capacity;
	private Key[] heap;
	private int N; //items
	public static boolean DEBUG = false;

	/**************** Priority Queue API ***************/
	
	/*
		Create an empty Priority Queue
	 */
	public MaxPQ(){

		this.heap = (Key [])new Comparable[DEFAULT_CAPACITY + 1];
		this.N = 0;
	}


	/*
		Create a PQ with given keys
	 */
	public MaxPQ(Key[] ks){
		this.capacity = ks.length + 2 > DEFAULT_CAPACITY ? ks.length +2 : DEFAULT_CAPACITY;//[0] th place is unused
		this.heap = (Key [])new Comparable[this.capacity];
		this.N = 0;
		buildHeap(ks);
	}

	void buildHeap(Key[] ks){
		print("Array:\t");
		for (Key k : ks){
			print(k + " ");
			insert(k);
		}
		println("");
	}


	/*
		Insert a key into the PQ
		Logic: Add node at end, then swim it up.
		Cost. At most 1 + lg N compares.
	 */
	public void insert(Key v){
		heap[++N] = v;
		swim(N);
	}


	//TODO
	/*
		Remove the largest key and return it
	 	Logic: Exchange root with node at end, then sink it down.
	 	Cost: At most 2 lg N compares. each time 2 compares
	 	to  determine 1. which child greater, 2. is parent greater 
	 	than biggest child.
	 */
	public Key delMax(){
		if(isEmpty()) {
			return null;
		}
		Key max = heap[1];
		exch(1,N);
		N--; // delete the last element
		sink(1);
		return max;
	}


	//TODO
	/*
		Is PQ Empty?
	 */
	public boolean isEmpty(){
		
		return N == 0;
	}

	/**************** PQ API extras *************/

	
	/*
		Return the largest key
	 */
	public Key max(){
	
		return heap[1];
	}

	/*
		Size of PQ
	 */
	int size(){
	
		return N;
	}

	/**************** Heap Helpers *************/

	/*
		Move k up if k's parents is smaller than k.
		Keep on doing it till heap order is restored.
	 */
	void swim(int k){

		while(k > 1){ //repeat unitl reached root 

			if( less(parent(k), k)){ // if parent is smaller than me, MOVE ME UP
				exch(k, parent(k)); 
				k = parent(k); 
			}else 
				break; // parent is greater than equal to me, heap order restored, stop swimming

		}
	}

	/*
		Move k down if k's children is bigger than k. Swap k with large child
		Keep on doing it till heap order is restored.
	 */

	void sink(int k){

		while(leftChild(k) <= N ){ //2k is k's children, 2k<=N means k has children
						  		   //so repeat until K has children
			
			int j = leftChild(k);
			int bigger_child = j<N && less(j,j+1) ? j+1 : j; //find bigger child, j< N to ensure there is 
															 //right child so u can access j+1
			
			if(less(k,bigger_child)){
				exch(k, bigger_child); 
				k = bigger_child; // do checking at new child, by updating k
			}else{
				break; //heap order restored
			}
		}
	}


	int leftChild(int k){
		
		return 2*k;
	}



	int rightChild(int k){
		
		return (2*k+1);
	}


	int parent(int k){
		
		return k/2;
	}




	/*
		Print heap by level order
	 */
	void printHeap(){
		print("Heap:\t");
		for (int i = 1; i<=N; i++){
			print(heap[i] + " ");
		}
		println("");
	}


	/**************** Generics Helpers *************/
	
	/*
		Return true if heap[i] less than heap[j], else return false.
	 */
	boolean less(int i, int j){
		
		return heap[i].compareTo(heap[j]) < 0;
	}

	
	/*
		Exchange heap elems at index i, j
	 */
	void exch(int i, int j){
		
		Key temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp; 
	}

	/**************** Print Shortcut *************/

	static void println(Object a){
	
		System.out.println(a.toString());
	}

	static void print(Object a){
	
		System.out.print(a.toString());
	}


}