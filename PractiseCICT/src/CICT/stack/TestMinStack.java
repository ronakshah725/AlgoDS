package CICT.stack;

import java.util.Arrays;

import CICT.AssortedMethods;



public class TestMinStack{

public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(10, 0, 500);
		System.out.println(Arrays.toString(array));
		StackWithMin<Integer> stack1 = new StackWithMin<Integer>();		
		
		for (int a : array) {
		stack1.push(a);
		}
		stack1.push(54);
		
		while(!stack1.isEmpty()){
			
			System.out.println("Pop: " + stack1.peek() + ", Min: " + stack1.min());
			stack1.pop();
		}
		
	
	}

}