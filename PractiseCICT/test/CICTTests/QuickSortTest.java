package CICTTests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import CICT.QuickSort;

public class QuickSortTest {
	static int[] a;
	static int[] desc;
	@Before
	public void init(){
		a = new int[]{6,5,1,3,8,4,7,9,2};
		desc = new int[]{5,4,3,2,1};
		desc =a;
	}
	@Test
	public void testPartition() {
		int pivot_i = QuickSort.partition(desc, 0, 4);
		for(int i = 0;i<pivot_i; i++){
			assert(small(i, pivot_i));
		}
		
		for (int i = pivot_i+1; i < desc.length; i++) {
			assert(big(i,pivot_i));
		}
		System.out.println(Arrays.toString(desc));
		
	}
	
	@Test
	public void testQuickSort() {
		QuickSort.sort(a);
		for (int i = 0; i < a.length-1; i++) {
			assert(small(i,i+1));
		}
		System.out.println(Arrays.toString(a));

	}

	private boolean small(int i, int pivot_i) {
		return a[i]<a[pivot_i];
	}
	
	private boolean big(int i, int pivot_i) {
		return a[i]>a[pivot_i];
	}

}
