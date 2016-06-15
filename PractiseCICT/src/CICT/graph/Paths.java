package CICT.graph;

import java.util.Stack;

public class Paths {
	private final int s;
	protected boolean[] marked ;
	protected int[] edgeTo;
	
	public Paths(Graph g, int s) {
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		marked[s] = true;
	}

	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	 public Stack<Integer> pathTo(int v) {
		 
		 if(!hasPathTo(v)) return null;
		 Stack<Integer> path = new Stack<>();
		 int b = v;
		 while(b != s){
			 path.push(b);
			 b = edgeTo[b];
		 }
		 path.push(s);
		 return path;
		 
	 }
}
