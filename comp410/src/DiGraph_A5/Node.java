package DiGraph_A5;

import java.util.HashSet;

public class Node {
	public long idNum; 
	public String label; 
	public long dist = Long.MAX_VALUE;
	//public int distance = Integer.MAX_VALUE; 
	
	public HashSet<Edge> inEdges; 
	public HashSet<Edge> outEdges; 
	
	boolean visited = false; 

	
	public Node(long idNum, String label) {
		this.idNum = idNum; 
		this.label = label; 
		
		
		inEdges = new HashSet<Edge>(); 
		outEdges = new HashSet<Edge>();
	}
	

}