package CICT;


// {6,5,1,3,8,4,7,9,2};
public class QuickSort {
	public static void sort(int[] a){
		sort(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int left, int right){
		if(left>=right)
			return;
		int pivot = partition(a, left, right);
		sort(a,left,pivot-1);
		sort(a,pivot+1, right);
	}

	public static int partition(int[] a, int left,int right){
		int pivot = a[right];
		int wall = left;
		int curr = left;
		while(curr<right){
			if(a[curr] < pivot){
				swap(a, wall, curr);
				wall++;
			}
			curr++;
		}
		swap(a, wall, right );
		return wall;
	}
	
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
