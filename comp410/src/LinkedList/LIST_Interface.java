package LinkedList;

public interface LIST_Interface {
    public boolean insert(double elt, int index);
    public boolean remove(int index);
    public double get(int index);
    public int size();
    public boolean isEmpty();
    public void clear();
}