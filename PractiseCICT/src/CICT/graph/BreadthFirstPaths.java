package CICT.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {
	private int[] distTo;
	private final int s;

	public BreadthFirstPaths(Graph g, int s) {
		
		super(g, s);
		this.s = s;
		distTo = new int [g.V()];
		bfs(g, s);
		
	}

	public void bfs(Graph g, int v) {

		Queue<Integer> q = new LinkedList<>();
		marked[v] = true;
		distTo[v] = 0;
		q.add(v);
		while(!q.isEmpty()){
			v = q.remove();
			for(int w: g.adj(v)){
				if(!marked[w]){
					q.add(w);
					edgeTo[w] = v;
					marked[w] = true;
					distTo[w] = distTo[v] + 1; 
				}
			}
		}

	}
	
	public int getDistTo(int v) { return distTo[v]; }

}


