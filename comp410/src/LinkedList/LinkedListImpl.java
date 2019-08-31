package LinkedList;

public class LinkedListImpl implements LIST_Interface {
    Node sentinel; //entry point to linked list (the head)

    public LinkedListImpl() {
        sentinel = new Node(0);
    }

    public Node getRoot() {
        return sentinel;
    }

    int numElts = 0;

    public boolean insert(double elt, int index) {
        if (index < 0 || index > size()) {
            return false;
        }

        Node n = new Node(elt);
        Node a = sentinel;

        if (isEmpty()) {
            sentinel.next = n;
            sentinel.prev = n;
            n.next = sentinel;
            n.prev = sentinel;
            numElts++;
            return true;
        } else {
            for (int i = 0; i <= index; i++) {
                a = a.next;
                if (i == index) {
                    a.prev.next = n;
                    n.prev = a.prev;
                    a.prev = n;
                    n.next = a;
                    numElts++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(int index) {
        Node n = sentinel;

        if (index < 0 || index >= size()) {
            return false;
        }

        for (int i = 0; i <= index; i++) {
            n = n.next;
            if (i == index && n.prev == sentinel && n.next == sentinel) {
                sentinel.next = null;
                sentinel.prev = null;
                numElts--;
                return true;
            } else if (i == index) {
                n.next.prev = n.prev;
                n.prev.next = n.next;
                numElts--;
                return true;
            }
        }
        return false;
    }

    public double get(int index) {
        Node n = sentinel;

        if (index >= size() || index < 0) {
            return Double.NaN;
        }
        for (int i = 0; i <= index; i++) {
            n = n.next;
            if (i == index) {
                return n.data;
            }
        }
        return 0;
    }

    public int size() {
        return numElts;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void clear() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        numElts = 0;
    }
}