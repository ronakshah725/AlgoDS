package CICT.stack;

public class SortStack {
	
	public static MyStack<Integer> sort(MyStack<Integer> stack){
		MyStack<Integer> sorted = new MyStack<>();
		
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!sorted.isEmpty() && temp >  sorted.peek()){
				stack.push(sorted.pop());
			}
			sorted.push(temp);
		}
		return sorted;
	}
	
	public static void main(String[] args) {
		MyStack<java.lang.Integer> m = new MyStack<>();
		m.push(5);
		m.push(2);
		m.push(6);
		m.push(7);
		
		m = SortStack.sort(m);
		while(!m.isEmpty()){
			System.out.println(m.pop());
		}
		
	}

}
