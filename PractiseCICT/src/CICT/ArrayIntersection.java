package CICT;

import java.util.*;

// Sol1 : Bin Search, useful when big >> small, sorting needed ofcourse
// Time Complexity to find intersection after sorting: O(min(mLogn, nLogm))
// Space Complexity: O(arr1 ^ arr2) extra space

class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1len = nums1.length;
        int n2len = nums2.length;
        int[] small, big;
        
        if(n1len == 0 || n2len == 0)
            return new int[]{};
        
        if(n1len < n2len){ //find the smaller and bigger array
            small = nums1;
            big = nums2;
        }else{
            small = nums2;
            big = nums1;
        }

        // TestLL.println("small: " + Arrays.toString(small) + ", big: " + Arrays.toString(big));
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i<big.length; i++){
            if(i == 0 || i>0 && big[i] != big[i-1]) // avoid dups
            {   
                // TestLL.println("Testing : " + big[i]);
                if(binarySearch(small, big[i]))
                    temp.add(big[i]);
            }
        }
        // TestLL.println("Res array: " + temp);
        int[] res = new int[temp.size()];

        for (int r = 0; r < temp.size(); r++)
            res[r] = temp.get(r);
        
        return res;
    }
        
    
    static boolean binarySearch(int[] arr, int val ){
        int l = 0;
        int r = arr.length-1;
        
        while(l<=r){
            
            // find mid
            int mid = l + (r-l)/2;
            
            if(arr[mid] == val) 
                return true;
            else if(arr[mid] >= val ) //left part
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}


// sol2: Two pointers: 1. sort 2. pointer one to arr1, pointer two to arr2, move smaller pointer ahead, if same, move both
// pointers ahead. 
// Constraint: Result to be stored in a set, because if num1 = [4,4, 6] and num2 = [4,4,7] then res = [4,4] since
// will go in else for both 4's . Expected res : [4] 
// Time Complexity to find intersection after sorting: O(m+n)
// Space Complexity: O(arr1 ^ arr2) extra space

class Solution2{
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1len = nums1.length;
        int n2len = nums2.length;
        
        if(n1len == 0 || n2len == 0)
            return new int[]{};
        
        // TestLL.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2));
        Set<Integer> temp = new HashSet<>();

        //i points to smaller, j to bigger
        for(int i = 0, j = 0; i<nums1.length && j< nums2.length;){
        
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }else{
                temp.add(nums1[i]);
                i++;
                j++;
            }           
        }

        int[] res = new int[temp.size()];
        int r = 0;
        for(Integer s : temp){
            res[r++] = s;
        }
        
        return res;
    }


}


public class ArrayIntersection{
    public static void main(String[] args) {

        //Test Sol1
        int[] res = new Solution1().intersection(new int[]{4,6,7,9,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4});
        TestLL.println("result : " + Arrays.toString(res));

        //Test binary search
        boolean result = Solution1.binarySearch(new int[]{0,0,1,2,2,4,5,6,6}, 0);
        TestLL.println("Binary Search res : " + result); 

        //Test Sol2
        int[] res2 = new Solution2().intersection(new int[]{4,6,7,9,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4});
        TestLL.println("result : " + Arrays.toString(res2));
    }
}