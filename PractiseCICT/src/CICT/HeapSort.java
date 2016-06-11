package CICT;

	
/*
	In Place HeapSort
	// build heap in bottom up fashion, up means use sink
 */
public class HeapSort<Key extends Comparable<Key>>{

	public Key[] max_heap;
	int N;

	public HeapSort(){
	}

	public void initHeap(Key[] ks){
		N = ks.length;
		max_heap = ks;
	
	}

	void buildMaxHeap(){

		for(int k = parent(N); k>0; k-- ){ //Heapify bottom up from parent of last node
			sink(k);
		}
	}

	public void sort(){
		this.buildMaxHeap();
		while(N > 1 ){
			exch(1,N--);
			sink(1);
			
		}

	}

	/**************** PQ API extras *************/

	
	/*
		Return the largest key
	 */
	public Key max(){
	
		return max_heap[1];
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
		Keep on doing it till max_heap order is restored.
	 */
	void swim(int k){

		while(k > 1){ //repeat unitl reached root 

			if( less(parent(k), k)){ // if parent is smaller than me, MOVE ME UP
				exch(k, parent(k)); 
				k = parent(k); 
			}else 
				break; // parent is greater than equal to me, max_heap order restored, stop swimming

		}
	}

	/*
		Move k down if k's children is bigger than k. Swap k with large child
		Keep on doing it till max_heap order is restored.
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
				break; //max_heap order restored
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
		Print max_heap by level order
	 */
	public void printHeap(Key[] max_heap){
		print("Heap:\t");
		for (int i = 0; i<max_heap.length; i++){
			print(max_heap[i] + " ");
		}
		println("");
	}


	/**************** Generics Helpers *************/
	
	/*
		Return true if max_heap[i] less than max_heap[j], else return false.
	 */
	boolean less(int i, int j){
		i--;
		j--;
		return max_heap[i].compareTo(max_heap[j]) < 0;
	}

	
	/*
		Exchange max_heap elems at index i, j
	 */
	void exch(int i, int j){
		i--;
		j--;
		Key temp = max_heap[i];
		max_heap[i] = max_heap[j];
		max_heap[j] = temp; 
	}

	/**************** Print Shortcut *************/

	static void println(Object a){
	
		System.out.println(a.toString());
	}

	static void print(Object a){
	
		System.out.print(a.toString());
	}






}
