package CICT.graph;

import java.util.Stack;

public class TestDFS_BFS {

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

		int s = 2;
		System.out.println("DFS Paths:");
		testDFS(g, s);
		System.out.println("\n");
		System.out.println("BFS Paths:");
		testBFS(g, s);
	}

	public static void testBFS(Graph g, int s) {
		Paths bfs = new BreadthFirstPaths(g, s);
	
        for (int v = 0; v < g.V(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.format("%d to %d:  ", s, v);
                Stack<Integer> vpath = bfs.pathTo(v);
                int x;
                while(!vpath.isEmpty()){
                	 x = vpath.pop();
                	System.out.print( x + " ");
                }
                System.out.println("\t[" + ((BreadthFirstPaths) bfs).getDistTo(v)+"]");
            }else{
            	System.out.format("%d to %d:  not connected\n", s, v);
            }
        }
	}

	public static void testDFS(Graph g, int s) {
		Paths dfs = new DepthFirstPaths(g, s);
		
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
