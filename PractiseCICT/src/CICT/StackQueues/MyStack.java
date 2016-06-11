package CICT.StackQueues;

import java.util.EmptyStackException;

public class MyStack<T>{
	StackNode<T> top;

	public T pop(){
		if(isEmpty()) throw new EmptyStackException();
		T item  = top.data;
		top = top.next;
		return item;
	}

	public T peek(){
		if(isEmpty()) throw new EmptyStackException();
		return top.data;
	}

	public void push(T item){
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public boolean isEmpty(){
		return top == null;
	}

	class StackNode<T>{

		T data;
		StackNode<T> next;

		StackNode(T item){
			this.data = item;
		}

		@Override
		public String toString(){
			return data.toString();
		}
	}
}
