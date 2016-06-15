package CICT.graph;

import java.util.Stack;

public class DepthFirstPaths {
	private final int s;
	private boolean[] marked ;
	private int[] edgeTo;
	
	public DepthFirstPaths(Graph g, int s) {
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		marked[s] = true;
		dfs(g,s);
	}

	private void dfs(Graph g, int v) {
		marked[v] =true;
		for (int w : g.adj(v))
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(g,w);
				
			}
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
