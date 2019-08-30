package DiGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
	private HashSet<Long> edge_ids = new HashSet<Long>(); 

	Map<Long, String> edgeMap = new HashMap<Long, String>();
	Map<Long, String> NodeMap = new HashMap<Long, String>();

	Map<String, Node> NodeComp = new HashMap<String, Node>();
	Map<String, Edge> edgeComp = new HashMap<String, Edge>(); 
	
	ArrayList<Node> nodeList = new ArrayList<Node>(); 
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
			
  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }
  
	public boolean addNode(long idNum, String label) {
		if(idNum < 0) {
			return false; 
		} else if (label == null) {
			return false; 
		}
		
		if (NodeMap.containsKey(idNum)||NodeMap.containsValue(label)) {
			return false; 
		} else {
			Node NodeConObj = new Node(idNum, label);
			nodeList.add(NodeConObj);
			NodeMap.put(idNum, label);
			NodeComp.put(label, NodeConObj);
			return true; 
		}
	}
	
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {		
		Edge edgeVar = new Edge( idNum,  sLabel,  dLabel,  weight,  eLabel);
		
		if (idNum < 0) {
			return false; 
		}
		
		if (edgeMap.containsKey(idNum)){
			return false;
		}

		if(NodeMap.containsValue(dLabel) == false || NodeMap.containsValue(sLabel) == false) {
			return false; 
		}

		if (edgeComp.containsKey(labelCombiner(sLabel, dLabel))){
			return false;
		}

		if (NodeComp.get(sLabel).label.equals(sLabel) || NodeComp.get(dLabel).label.equals(dLabel)) {
			edgeVar.destNode = NodeComp.get(dLabel);
			edgeVar.srcNode = NodeComp.get(sLabel);
			edgeVar.destNode.inEdges.add(edgeVar);
			edgeVar.srcNode.outEdges.add(edgeVar);

			edgeMap.put(idNum, eLabel);
			edgeList.add(edgeVar);
			edgeComp.put(labelCombiner(sLabel, dLabel), edgeVar);
			return true;
		}
		return false;		
	}
	
	
	public boolean delNode(String label) {
		if(NodeMap.containsValue(label) == false) {
			return false; 
		}
		else {
			Node localNode = NodeComp.get(label);
			NodeMap.remove(localNode.idNum);
			nodeList.remove(localNode);
			NodeComp.remove(label);
			
			for (Edge edgy : localNode.inEdges) {
				edgy.srcNode.outEdges.remove(edgy);
				edge_ids.remove(edgy.idNum);
				edgeMap.remove(edgy.idNum);
				edgeList.remove(edgy);
				edgeComp.remove(labelCombiner(edgy.srcNode.label, edgy.destNode.label));
			}

			for (Edge edgy : localNode.outEdges) {
				edgy.destNode.inEdges.remove(edgy);
				edge_ids.remove(edgy.idNum);
				edgeMap.remove(edgy.idNum);
				edgeList.remove(edgy);
				edgeComp.remove(labelCombiner(edgy.srcNode.label, edgy.destNode.label)); 
			}
			return true;
		}
	}
	
	public boolean delEdge(String sLabel, String dLabel) {
		if(edgeComp.containsKey(labelCombiner(sLabel, dLabel))) {
			Edge localEdge = edgeComp.get(labelCombiner(sLabel, dLabel));
			
			localEdge.srcNode.outEdges.remove(localEdge);
			localEdge.destNode.inEdges.remove(localEdge);
			edgeMap.remove(localEdge.idNum);
			edgeList.remove(localEdge);
			edgeComp.remove(labelCombiner(sLabel, dLabel));

			localEdge.sLabel = null; 
			localEdge.dLabel = null; 
			return true; 
		}
		return false; 
	}
	
	
	public long numNodes() {
		return NodeMap.size();
	}
	
	public long numEdges() {
		return edgeMap.size();
	}
	
	

	public ShortestPathInfo[] shortestPath(String label) {
		MinBinHeap mbh = new MinBinHeap();
		NodeComp.get(label).dist = 0; 
		mbh.insert(new EntryPair(label, NodeComp.get(label).dist)); 
		
		while (mbh.size() > 0) {
			Node temp = NodeComp.get(mbh.getMin().value);
			System.out.println(temp.label);
			mbh.delMin(); 
			
			temp.visited = true; 
			
			for (Edge e : temp.outEdges) {
				if ((e.destNode.dist > temp.dist + e.weight) && e.destNode.visited == false) {
					e.destNode.dist = temp.dist + e.weight; 
					
					mbh.insert(new EntryPair(e.destNode.label, e.destNode.dist));
				}
			}
		}
		
		ShortestPathInfo[] pathInfo = new ShortestPathInfo[nodeList.size()]; 
		int i = 0; 
		
		for (Node v: nodeList) { 
			if (v.visited == false) {
				v.dist = -1; 
			}
			
			pathInfo [i] = new ShortestPathInfo(v.label, v.dist);
			i++; 
		}
		return pathInfo;
	}
	
	public String labelCombiner(String l1, String l2) {
		return l1 + "filler" +  l2;
	}
}