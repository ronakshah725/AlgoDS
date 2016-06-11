

/*


	LeetCode 3SUM: 
	Problem 15: Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) **HINTS TO: SORT
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4}, **HINTS TO : SORT

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
	public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1,-4};
        System.out.println("Array " + Arrays.toString(arr));
		System.out.println("Triplets " + (new Solution().threeSum(arr)));

	}
}

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            
            if(i==0 || i>0 && nums[i] != nums[i-1]){ // Do 2sum if i == 0 or i > 0 and nums[i] not a duplicate
               
                int j = i+1;
                int k = nums.length - 1;
               
                while(j<k){
               
                    if(nums[i]+nums[j]+nums[k] == 0){ // found result
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        res.add(triplet);
                        j++;    //
                        k--;    //j,k are processed, move j,k till unique j,k found for processing
                        //remove duplicate b's and c's 
                        while(j<k && nums[j]==nums[j-1])j++;
                        while(j<k && nums[k]==nums[k+1])k--;
                        
                    }
                    
                    else if(nums[i]+nums[j]+nums[k] < 0){ // sum needs bigger values to reach 0, goto bigger r
                        j++;
                    }
                    
                    else{ // sum needs smaller values to equal 0, goto smaller k
                        k--;
                    }
                    
                }//--end while
            }//--end duplicate check if
        }//--end for
        
        return res;
    }
}
