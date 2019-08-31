/**
 * COMP 410
 * Don't modify this file!
 */

package LinkedList;

public class Node {
    public double data;
    public Node next; //links this node to the next Node in the List
    public Node prev; //links this node to the preceding Node in the List (ie this Node is the prev Node's next node)
    public Node(double data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public String toString() {
        return "data: " + data + "\thasNext: " + (next != null) + "\t\thasPrev: " + (prev != null);
    }

    public boolean isNode() { //testing purposes please do not touch!
        return true;
    }
    public double getData() { //testing purposes please do not touch!
        return data;
    }
    public Node getNext() { //testing purposes please do not touch
        return next;
    }
    public Node getPrev() { //testing purposes please do not touch
        return prev;
    }
}