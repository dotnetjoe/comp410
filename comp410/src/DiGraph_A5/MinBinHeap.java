package DiGraph_A5;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		  return this.array;
	}

	public void insert(EntryPair entry) {
		if(size == array.length - 1) {
			doubleSize();
		}

		//Insert a new item to the end of the array
		int position = size+1;

		//Traverse up
		for(; position > 1 && entry.getPriority() < (array[position/2].getPriority()); position = position/2 ) {
			array[position] = array[position/2];
		}

		array[position] = entry;
		size++;
	}

	public void delMin() {
		if (size > 0) {
			array[1] = array[size];
			sort(1);
			size--;
		}
	}
		
	public EntryPair getMin() {
		return array[1];
	}
	
	public int size() {
		return size;
	}
	
	public void build(EntryPair[] entries) {
		for (int i = 0; i<entries.length; i++) {
			array[i+1] = entries[i];
			size++;
		}

		for (int k = size/2; k > 0; k--) {
			sort(k);
		}
	}
	   
	private void doubleSize() {
		EntryPair [] old = array;
		array = (EntryPair []) new Comparable[array.length * 2];
		System.arraycopy(old, 1, array, 1, size);
	}
	
	private void sort(int k) {
		EntryPair temp = array[k];
		int child;

		for(; 2*k <= size; k = child) {
			child = 2*k;

			if (child != size && array[child].getPriority() > array[child + 1].getPriority()) {
				child++;
			}
			
			if (temp.getPriority() > array[child].getPriority()) { 
				array[k] = array[child];
			} else {
                break;
			}
		}
		array[k] = temp;
	}
}