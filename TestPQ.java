public class TestPQ{

	public static void main(String[] args) {
		// MaxPQ.DEBUG = true;
		MaxPQ<Integer> maxpq = new MaxPQ<>(new Integer[]{2,7,3,4,9,1});
		maxpq.printHeap();

		//Delete Max
		print("\nDelete max : ");
		Integer max = (Integer) maxpq.delMax();
		println(max);
		println("Heap size: " + maxpq.size());
		maxpq.printHeap();		

		


	}

	/**************** Print Shortcut *************/

	static void println(Object a){
		System.out.println(a.toString());
	}

	static void print(Object a){
		System.out.print(a.toString());
	}


}