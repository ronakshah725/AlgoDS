package CICT.sort;

public class Insertion implements Timeable{

	/*
		When to choose
			when the data is nearly sorted 
			when the problem size is small (because it has low overhead)
	 	Properties
			Stable
			O(1) extra space
			O(n^2) comparisons and swaps
			Adaptive: O(n) time when nearly sorted
			Very low overhead
		Idea:
			1. Take one item from input list
			2. Insert into appropriate position in sorted list
			   by swapping.
			3. repeat 1-2 for all elems in input list
	 */
	
	public static int[] sort(int[] a){
		int len = a.length;
		for(int i = 1; i < len; i++){
			for(int j = i; j >= 1 && (a[j] < a[j-1]); j--){
				swap(a,j,j-1);
			}
		}
		return a;
	}

	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public long getRuntime(int[] rta){
		long startTime = System.nanoTime();
		sort(rta);
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

}