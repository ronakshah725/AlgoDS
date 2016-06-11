package CICT.stack;

public class StackWithMin<Integer> extends MyStack<Integer> {
	
	MyStack<Integer> minStack;
	StackNode<Integer> top2;
	public StackWithMin() {
		minStack = new MyStack<>();
	}
	
	public void push(Integer item){
		if((int)item<min())
			minStack.push(item);
		super.push(item);
	}
	
	public Integer pop(){
		Integer value = super.pop();
		if((int)value == min())
			minStack.pop();
		return value;
	}
	
	public int min(){
		
		if(minStack.isEmpty())
			return 500000000;
		return (int) minStack.peek();
	}
	
	
}
