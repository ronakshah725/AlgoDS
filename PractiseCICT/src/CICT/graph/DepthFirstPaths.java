package CICT.graph;

import java.util.Stack;

public class DepthFirstPaths extends Paths {
	private final int s;
	
	public DepthFirstPaths(Graph g, int s)  {
		super(g,s);
		this.s = s;
		dfs(g,s);
	}

	public void dfs(Graph g, int v) {
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
