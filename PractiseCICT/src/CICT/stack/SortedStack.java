package CICT.stack;

import java.util.Arrays;
import java.util.Stack;

import CICT.AssortedMethods;

/*
 * Maintain a stack such that smallest elems are at top.
 * Can use extra stack
 * 
 * Logic: Like bubble sort. Just think of push issues, pop is the same
 * 		push(T item)	
 * 			Stack o = getOperatingStack();	
 * 			Stack e = getEmptyStack();		
 * 			while(item>o.peek()){
 * 				e.push(o.pop());
 * 	
 * 			}
 * 			o.push(item);
 * 
 */
public class SortedStack {
	
	Stack<Integer> sorted, temp;

	public SortedStack() {
		sorted =  new Stack<>();
		temp = new Stack<>();
	}
	
	public void push(Integer item){
		
		while(!sorted.isEmpty() && item>sorted.peek()){
			temp.push(sorted.pop());
		}
		sorted.push(item);
		while(!temp.isEmpty()){
			sorted.push(temp.pop());
		}
	}
	
	public Integer pop(){
		return sorted.pop();
	}
	
	public Integer peek(){
		return sorted.peek();
	}
	
	public boolean isEmpty(){
		return sorted.isEmpty();
	}
	
	public static void main(String[] args) {
		SortedStack s = new SortedStack();
		int[] arr = AssortedMethods.randomArray(10000, 0, 10000000);
		System.out.println(Arrays.toString(arr));
		for (int a : arr){
			s.push(a);
		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	
	
}
