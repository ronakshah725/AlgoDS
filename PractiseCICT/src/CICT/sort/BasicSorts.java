package CICT.sort;

/*

	Reference: https://www.toptal.com/developers/sorting-algorithms
	Stable in sorting
 	A sorting algorithm is said to be stable if two objects with 
	equal keys appear in the same order 
	in sorted output as they appear in the input array to be sorted.
*/
 public class BasicSorts{


	public static int[] sort(String algo, int[] a){
		algo.toLowerCase();
		int[] res = null;
		switch(algo){
			case "insertion":
						res = Insertion.sort(a);
						break;
			// case "selection":
			// 			res = selectionSort(a);
			// 			break;
			// case "bubble":
			// 			res = bubbleSort(a);
			// 			break;
			// case "shell":
			// 			res = shellSort(a);
			// 			break;
			// case "merge":
			// 			res = mergeSort(a);
			// 			break;
			// case "quick":
			// 			res = quickSort(a);
			// 			break;
			// case "quick3":
			// 			res = quick3Sort(a);
			// 			break;
			// case "heap":
			// 			res = heapSort(a);
			// 			break;
		}
		return res;
	}

}
