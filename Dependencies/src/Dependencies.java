import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Dependencies{

	public static void main(String[] args) throws IOException {

		//		if(args.length < 1){
		//			System.out.println("Usage: Dependencies conf-file"); 
		//			System.exit(1);
		//		}
		HashMap<String, Node> programs = readDependencies("dep2.conf");

		LinkedList<Node> allNodes= new LinkedList<>(programs.values());
//		printParallel(allNodes);
//		System.exit(1);
		topoSort(allNodes);


	}

	private static void topoSort(LinkedList<Node> allNodes) {
		ArrayList<Node> L = new ArrayList<Node>();

		//S <- Set of all nodes with no incoming edges
		LinkedList<Node> S = new LinkedList<>();
		for(Node n : allNodes){
			if(n.inEdges.size() == 0){
				S.add(n);
				System.out.print(n + " ");

			}
		}
		System.out.println();

		//while S is non-empty do
		while(!S.isEmpty()){
			//System.out.println(S);
			//remove a node n from S
			
			Iterator<Node> SIterator = S.iterator();
			Node n = SIterator.next();
			SIterator.remove();
			//insert n into L
			L.add(n);
			
			
			//for each node m with an edge e from n to m do
			Iterator<Edge> it = n.outEdges.iterator();
//			if(!it.hasNext())
				
			while(it.hasNext()){
				//remove edge e from the graph
				Edge e = it.next();
				Node m = e.to;
				it.remove();//Remove edge from n
				m.inEdges.remove(e);//Remove edge from m

				//if m has no other incoming edges then insert m into S
				if(m.inEdges.isEmpty()){
					S.add(m);
				}
				it.hasNext();
			}

		}
		//Check to see if all edges are removed
		boolean cycle = false;
		for(Node n : allNodes){
			if(!n.inEdges.isEmpty()){
				cycle = true;
				break;
			}
		}
		if(cycle){
			System.out.println("Cycle present, topological sort not possible");
		}else{
			System.out.println("Topological Sort: "+Arrays.toString(L.toArray()));
		}
	}

	private static void printParallel(LinkedList<Node> allNodes) {
		
		
	}

	public static HashMap<String, Node>  readDependencies(String confFileName) throws IOException{
		BufferedReader br;
		br = new BufferedReader(new FileReader(confFileName));
		Pattern pattern = Pattern.compile("(.*)(:)(.*)");
		String line;

		HashMap<String, Node> nodes = new HashMap<>();

		while((line = br.readLine()) != null ){
			if(line.startsWith("#")) continue; //comments start with #
			Matcher matcher = pattern.matcher(line);	
			while (matcher.find()) {
				String name = matcher.group(1).trim(); //
				Node successor;
				String[] predecessors = matcher.group(3).trim().split("[\\s]*,[\\s]*");

				if(!nodes.containsKey(name)){
					successor = new Node(name);
					nodes.put(name, successor);
				}else{
					successor = nodes.get(name);
				}
				for(String p : predecessors){

					if(p.equals("")) continue;

					Node parent = nodes.get(p);
					if(parent==null)
						parent = new Node(p);
					parent.addEdge(successor);
					nodes.put(p, parent);
				}
			}
		}
		br.close();
		return nodes;
	}


}

class Node{
	public final String name;
	public final HashSet<Edge> inEdges;
	@Override
	public String toString() {
		return  name ;
	}
	public final HashSet<Edge> outEdges;

	public Node(String name) {
		this.name = name;
		inEdges = new HashSet<Edge>();
		outEdges = new HashSet<Edge>();
	}
	public void addEdge(Node node){
		Edge e = new Edge(this, node);
		outEdges.add(e);
		node.inEdges.add(e);
	}

}

class Edge{
	public final Node from;
	public final Node to;
	public Edge(Node from, Node to) {
		this.from = from;
		this.to = to;
	}
	@Override
	public boolean equals(Object obj) {
		Edge e = (Edge)obj;
		return e.from == from && e.to == to;
	}


}

/*
	Assumptions: 
	1. No cycles, else stop
	2. Stop if 
	3. No Duplicates

	Steps:

	1. Make conf file:

			A : ,
			B : A
			C : A
			D : A,B
			E : B,C,D

			A ->BCD -> E
 */