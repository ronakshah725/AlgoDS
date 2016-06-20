package CICTTests;

import CICT.sort.HeapSort;

public class TestHeapSort{

	public static void main(String[] args) {
		HeapSort<Integer> hs = new HeapSort<Integer>();
		hs.initHeap(new Integer[]{9,12,7,5,1});
		hs.sort();
		hs.printHeap(hs.max_heap);
	}
}