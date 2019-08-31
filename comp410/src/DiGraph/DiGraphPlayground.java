package DiGraph;

public class DiGraphPlayground {

    public static void main(String[] args) {
        exTest();
    }

    public static void exTest() {
        DiGraph d = new DiGraph();
        d.addNode(1, "f");
        d.addNode(3, "s");
        d.addNode(7, "t");
        d.addNode(0, "fo");
        d.addNode(4, "fi");
        d.addNode(6, "si");
        d.addEdge(0, "f", "s", 0, null);
        d.addEdge(1, "f", "si", 0, null);
        d.addEdge(2, "s", "t", 0, null);
        d.addEdge(3, "fo", "fi", 0, null);
        d.addEdge(4, "fi", "si", 0, null);
        System.out.println("numEdges: " + d.numEdges());
        System.out.println("numNodes: " + d.numNodes());
    }
}