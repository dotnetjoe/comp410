package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" s
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  public boolean containsNode(String s){ 
	  if (this != null && s.compareTo(this.getData()) == 0) {
		  return true;
	  } else if (this.left != null) {
			  if(s.compareTo(this.left.getData()) == 0) {
				  return true;
			  }
	  } else if (this.right != null) {
			  if(s.compareTo(this.right.getData()) == 0) {
				  return true;
			  }
	  } else {
		  if (s.compareTo(this.data) < 0) {
			  if (this.left != null) {
				  return this.left.containsNode(s);
			  }
		  } else if (s.compareTo(this.data) > 0) {
			  if (this.right != null) {
				  return this.right.containsNode(s);
			  }
		  }
	  }
	  return false;
  }
  
  public boolean insertNode(String s){ 
	  if (s.compareTo(this.getData()) < 0) {
			if (this.left == null) {
				this.left = new BST_Node(s);
				return true;
			} else {
				return this.left.insertNode(s);
			}
	  }
	  if (s.compareTo(this.getData()) > 0) {
			if (this.right == null) {
				this.right = new BST_Node(s);
				return true;
			} else {
				return this.right.insertNode(s);
			}
	  }
	  return false;
  }
  
//  public boolean removeNode(BST_Node n, String s){ 
//		if (n == null) {
//			return false;
//		} 
//		if (n.contains(s)) {
//			if (n.getData().compareTo(s) < 0) {
//				return n.right.removeNode(n, s);
//			} else if (n.getData().compareTo(s) > 0) {
//				return n.left.removeNode(n, s);
//			} else if (n.left != null && n.right != null) {
//				n.data = n.left.findMax().data;
//				return n.left.removeNode(n, n.left.findMax().data);
//			} else if (size() == 1) {
//				n = null;
//				return true;
//			} else {
//				if (n.left == null) {
//					n = n.right;
//					return true;
//				}
//				if (n.right == null) {
//					n = n.left;
//					return true;
//				}
//			}
//		}
//		return false;
//  }
  
  public boolean removeNode(String s, BST_Node node) {
	  // Compare s to this node
	  if (s.compareTo(this.data) < 0) {
			if (left != null) {
			      return left.removeNode(s, this);
			} else {
			    return false;
			}
	  } else if (s.compareTo(this.data) > 0) {
	        if (right != null) {
	              return right.removeNode(s, this);
	        } else {
	        	return false;
	        }
	  } else {
	        if (left != null && right != null) {
	              this.data = right.findMin().data;
	              right.removeNode(this.data, this);
	        } else if (node.left == this) {
	              node.left = (left != null) ? left : right;
	        } else if (node.right == this) {
	              node.right = (left != null) ? left : right;
	        }
	        return true;
	  }
  }
  
  public BST_Node findMin(){ 
		if (this.left == null) {
			return this;
		} else {
			return this.left.findMin();
		}  
  }
  
  public BST_Node findMax(){ 
		if (this.right == null) {
			return this;
		} else {
			return this.right.findMax();
		}
  }
  
  public int getHeight(){ 
	  if (this.left == null && this.right == null) {
		  return 0;
	  } else {
			int leftNode = 0;
			int rightNode = 0;
			
			if (this.left != null) {
				leftNode = this.left.getHeight();
			}
			
			if (this.right != null) {
				rightNode = this.right.getHeight();
			}
			
			if (leftNode > rightNode) {
				return (leftNode + 1);
			} else {
				return (rightNode + 1);
			}
	  }
  }

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}