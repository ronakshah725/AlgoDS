

import java.util.*;

public class SumOfPairs{

	//O(n) space , O(n) time
	public static int getPairs(int[] arr, int target){
		int pairs = 0;
		
		Map<Integer, Integer> diffMap = new HashMap<>();
		
		//put in the diff,num in the map, only if num not in map
		//else dual of it 
		for(int x : arr){
			if(!diffMap.containsKey(x)) 
				diffMap.put(target - x, x);
		}
		
		// find the number that equalled target-x
		//remove it once found to avoid duplicates
		for(int x : arr)
			if(diffMap.containsKey(x)){
				diffMap.remove(x);
				pairs++;
			}
		return pairs;
	}

	//O(1) space , O(n*logn) time
	public static int getPairs2(int[] arr, int target){
		int pairs = 0, l = 0, r = arr.length-1;
		ArrayList<Pair> pairss = new ArrayList<>();
		Arrays.sort(arr);		
		int sum;
		while(l < r){
			sum = arr[l] + arr[r];
			if(sum<target)
				l++;
			else if(sum > target)
				r--;
			else{
				while(l<r && arr[l] == arr[l+1])
					l++;
				while(l<r && arr[r] == arr[r-1])
					r--;
				Pair p = new Pair(arr[l], arr[r]);
				pairss.add(p);
				pairs++;
				l++;
				r--;
			}
		}
		System.out.println("Pairs: " + pairss);
		return pairs;
	}
	


	static class Pair{
		int p1;
		int p2;
		
		public Pair(int p1, int p2) {
			this.p1 = p1;
			this.p2 = p2;
		}

		@Override
		public String toString() {
			return "[" + p1 + ", " + p2 + "]";
		}
		
	}


	public static void main(String[] args) {
		
		int pairs = SumOfPairs.getPairs(new int[]{6,21}, 12);
		System.out.println(pairs + ", " + SumOfPairs.getPairs2(new int[]{1,21}, 2));
	}
}
