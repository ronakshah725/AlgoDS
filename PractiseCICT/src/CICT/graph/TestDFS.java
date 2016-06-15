package CICT.graph;

import java.util.Stack;

public class TestDFS {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		
		g.addEdge(0, 5);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);

		int s = 0;
		DepthFirstPaths dfs = new DepthFirstPaths(g, s);
		
        for (int v = 0; v < g.V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.format("%d to %d:  ", s, v);
                Stack<Integer> vpath = dfs.pathTo(v);
                while(!vpath.isEmpty()){
                	int x = vpath.pop();
                	System.out.print( x + " ");
                }
                System.out.println();
            }else{
            	System.out.format("%d to %d:  not connected\n", s, v);
            }
        }
	}
}
