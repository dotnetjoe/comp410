# comp410
Comp 410 Data Structures

BST: Efficient implementation of a binary search tree data structure using delegation
----------
  
DiGraph: Efficient implementation of a directional graph data structure
----------

LinkedList: Efficient implementation of a linked list data structure without the use of arrays or the Java Collections Library.
----------

MinBinHeap: Efficient implementation of a priority queue by building a minimum binary heap.
----------

* **insert** Ordering is done based on the integer priorities in the elements that are inserted. Ignore the string for ordering. In the test data we use, the integer priorities in the elements will be unique -- there will be no duplicate priorities.

* **getMin** This operation returns an element (the entire object, priority and data value). It does NOT alter the heap. The heap has the same elements in the same arrangement after as it did before. If getMin is done on an empty heap, return null.

* **delMin** This operation removes the root element (the entire object) from the heap. The size of the heap goes down by 1 (if the heap was not already empty). If delMin is done on an empty heap, treat it as a no-op... i.e., do nothing other than return void.

* **build** The build operation should start with an empty heap. It receives an array of element objects as input. The effect is to produce a valid heap that contains exactly those input elements. This means when done the heap will have both a proper structure and will exhibit heap order. 
	Build is not the same as doing an insert for every element in the array. It is the special O(N) operation from the text (and shown in class) that starts with placing all elements into the heap array with no regard to heap order. You then go to the parent of the last node, and bubble down as needed. Go to the next node back towards the root, bubble down as needed. Repeat until you have done the root.

* **size** The size operation simply returns the count of how many elements are in the heap. It should be 0 if the heap is empty, and always return a 0 or greater.
