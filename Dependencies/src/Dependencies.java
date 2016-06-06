import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Dependencies{

	public static void main(String[] args) throws IOException {

		//		if(args.length < 1){
		//			System.out.println("Usage: Dependencies conf-file"); 
		//			System.exit(1);
		//		}
		HashMap<String, Node> programs = readDependencies("dep.conf");
		Set<Node> allNodes= new HashSet<Node>(programs.values());
		int concurrencyLimit = 2;
		printParallel(allNodes, concurrencyLimit);
	}

	private static void printParallel(Set<Node> allNodes, int limit) {
		System.out.println("Processing Order: ");
		int count = 0;
		int NoOfNodes = allNodes.size();
		List<Node> inZeroNodes ;

		while(count < NoOfNodes ){
			inZeroNodes = new LinkedList<>();
			boolean atLeastOne = false;
			for(Node n : allNodes ){
				if(n.indegree == 0 && !n.isVisited){
					n.isVisited = true;
					inZeroNodes.add(n);
					System.out.print(n);
					atLeastOne = true;
				}
			}
			if(!atLeastOne) 
				break;
			System.out.println();
			count++;
			ListIterator<Node> iterator = inZeroNodes.listIterator();
			while(iterator.hasNext()){
				Node n = iterator.next();
				for(Edge e : n.outEdges){						
					e.to.indegree--;
				}
			}
		}
		checkCycle(allNodes);		
	}

	private static void checkCycle(Set<Node> allNodes) {
		boolean cycle = false;
		for(Node n : allNodes){
			if(n.indegree != 0){
				cycle = true;
				break;
			}
		}
		if(cycle)	
			System.out.println("Cycle present, dependency ordering not possible !! ");
		else
			System.out.println("Done !!");
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
				Node child;
				String[] parents = matcher.group(3).trim().split("[\\s]*,[\\s]*");

				if(!nodes.containsKey(name)){
					child = new Node(name);
					nodes.put(name, child);
				}else{
					child = nodes.get(name);
				}
				for(String p : parents){

					if(p.equals("")) continue;

					Node parent = nodes.get(p);
					if(parent==null)
						parent = new Node(p);
					parent.addEdge(child);
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
	public int indegree;
	public boolean isVisited;

	public final HashSet<Edge> outEdges;

	public Node(String name) {
		this.name = name;
		indegree = 0;
		outEdges = new HashSet<Edge>();
		isVisited = false;
	}
	
	public void addEdge(Node node){
		Edge e = new Edge(this, node);
		outEdges.add(e);
		node.indegree++;
	}
	
	@Override
	public String toString() {
		return  name ;
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
