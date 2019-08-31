package DiGraph;

public interface DiGraphInterface {
  boolean addNode(long idNum, String label);
  boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel);
  boolean delNode(String label);
  boolean delEdge(String sLabel, String dLabel);
  long numNodes();
  long numEdges();
  ShortestPathInfo[] shortestPath(String label);
}