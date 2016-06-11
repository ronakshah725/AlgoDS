package CICT.stack;

import java.util.Arrays;
import java.util.Stack;

import CICT.AssortedMethods;

/*
 * Logic : Need Fifo from Lifo ds so modify pop, peek
 * Idea 1: while popping, shift all elems on to stack 2 and pop its top
 * Idea 2: Lazy approach. keep oldest and newest stacks(oldest on top, newest on top), 
 * 			push to new and pop from old.When pop is called, if there are some elems 
 * 			in oldest, pop from oldest. If oldest is empty, shift all from newest to
 * 			oldest and pop oldest 
 * 
 * ADT
 * add : add to tail
 * remove : remove from head
 * peek: retrieve, dont remove head
 * isEmpty, both are empty
 * 			
 * */

public class QueueWithStack<T> {
	
	private Stack<T> oldest, newest;
	
	public QueueWithStack() {
		
		oldest = new Stack<>();
		newest = new Stack<>();
	}
	
	public void add(T item){
		newest.push(item);
	}
	
	private void ShiftNewToOld(){
		if(oldest.isEmpty()){
			while(!newest.isEmpty()){
				oldest.push(newest.pop());
			}
		}
	}
	
	public T remove(){
		ShiftNewToOld();
		return oldest.pop();
	}
	
	public T peek(){
		ShiftNewToOld();
		return oldest.peek();
	}
	
	public int size(){
		return oldest.size() + newest.size();
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public static void main(String[] args) {
		QueueWithStack<Integer> q = new QueueWithStack<>();
		int[] arr = AssortedMethods.randomArray(15, 0, 500);
		System.out.println("Q:" + Arrays.toString(arr));
		for (int a : arr){
			q.add(a);
		}
		
		while(!q.isEmpty()){
			System.out.println(q.remove());
		}
	}

}
