package CICT.stack;


import java.util.EmptyStackException;

class MyStack<T>{
	StackNode<T> top;

	T pop(){
		if(isEmpty()) throw new EmptyStackException();
		T item  = top.data;
		top = top.next;
		return item;
	}

	T peek(){
		if(isEmpty()) throw new EmptyStackException();
		return top.data;
	}

	void push(T item){
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	boolean isEmpty(){
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