package CICT.DP;

public class MaxSubSeq{

	public static int maxSeq(int[] arr){
		int[] m = new int[arr.length];
		m[0] = arr[0];
		int max = m[0];
		for(int j=1; j<arr.length; j++){
			m[j] = Math.max(m[j-1] + arr[j], arr[j]); 		//either need to extend Mj to include Aj or start a new sum from Aj
			if(m[j] > max){
				max = m[j];
			}
		}
		return max;
	}

	

	public static void main(String[] args) {
		int max = MaxSubSeq.maxSeq(new int[]{1,-2,3,4,-1,});
		System.out.println(max);
	}
}