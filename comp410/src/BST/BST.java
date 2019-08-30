package BST;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }
  	
// Insert
//	public boolean insert(String s) {
//		if (this.contains(s)) {
//			return false;
//		}
//		root = insert(root, s);
//		size();
//		return true;
//		
//	}
//
//	public BST_Node insert(BST_Node node, String s) {
//		if (node == null) {
//			node = new BST_Node(s);
//			return node;
//		}
//		
//		if (s.compareTo(node.getData()) < 0) {
//			node.left = insert(node.left, s);
//			if (node.left == null) {
//				node.left = insert(node.left, s);
//				return true;
//			}
//		} else if (s.compareTo(node.getData()) > 0) {
//			node.right = insert(node.right, s);
//		}
//		return node;
//	}
	
	public boolean insert(String s) {
		if (this.contains(s)) {
			return false;
		}
		if (root == null) {
			root = new BST_Node(s);
			return true;
		}
		if (s.compareTo(root.getData()) < 0) {
			if (root.left == null) {
				root.left = new BST_Node(s);
				size();
				return true;
			} else {
				return root.left.insertNode(s);
			}
		} else if (s.compareTo(root.getData()) > 0) {
			if (root.right == null) {
				root.right = new BST_Node(s);
				size();
				return true;
			} else {
				return root.right.insertNode(s);
			}
		}
		return false;
	}
	
//	public boolean remove(String s) {
//		if (root == null) {
//			return false;
//		} 
//		if (contains(s)) {
//			if (root.getData().compareTo(s) < 0) {
//				return root.right.removeNode(root, s);
//			} else if (root.getData().compareTo(s) > 0) {
//				return root.left.removeNode(root, s);
//			} else if (root.left != null && root.right != null) {
//				root.data = root.left.findMax().data;
//				return root.left.removeNode(root, root.left.findMax().data);
//			} else if (size() == 1) {
//				root = null;
//				return true;
//			} else {
//				if (root.left == null) {
//					root = root.right;
//					return true;
//				}
//				if (root.right == null) {
//					root = root.left;
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	public boolean remove(String s) {
        if (root == null) {
              return false;
        } else {
              if (root.getData().compareTo(s) == 0) {
                    BST_Node newRoot = new BST_Node(s);
                    newRoot.left = root;
                    boolean result = root.removeNode(s, newRoot);
                    root = newRoot.getLeft();
                    return result;
              } else {
                    return root.removeNode(s, null);
              }
        }
	}
	
//	public boolean remove(String s) {
//		if (!this.contains(s)) {
//			return false;
//		}
//		root = remove(root, s);
//		size();
//		return true;
//	}
//	
//	public BST_Node remove(BST_Node node, String s) {
//		if (root == null) {
//			return root;
//		}
//		
//		if (s.compareTo(node.data) < 0) {
//			node.left = remove(node.left, s);
//		} else if (s.compareTo(node.data) > 0) {
//			node.right = remove(node.right, s);
//		}
//		
//		return node;
//	}

	
	public String findMin() {
		if (root == null) {
			return null;
		} else if (root.left == null) {
			return root.data;
		}
		
		return root.left.findMin().data;
		
//		if (size() == 0) {
//			return null;
//		}
//
//		String minNode = root.data;
//		
//		while (root.left != null) {
//			minNode = root.left.data;
//			root = root.left;
//		}
//		
//		return minNode;
	}
	
//	private String min(BST_Node node) {
//		if (size() == 0) {
//			return null;
//		}
//		
//		BST_Node minNode = node;
//		
//		while (minNode.left != null) {
//			minNode = minNode.left;
//		}
//		return minNode.data;
//	}

	public String findMax() {
		if (root == null) {
			return null;
		} else if (root.right == null) {
			return root.data;
		}
		
		return root.right.findMax().data;

//		String maxNode = root.data;
//		
//		while (root.right != null) {
//			maxNode = root.right.data;
//			root = root.right;
//		}
//
//		return maxNode;
	}
	
	public boolean empty() {
		if (root == null) {
			return true;
		}
		return false;
	}
	
	
	public boolean contains(String s) {
		if (this.root == null) {
			return false;
		}
		if (this.root.getData().compareTo(s) == 0) {
			return true;
		}
		if (root.left != null && root.left.containsNode(s)) {
			if (root.left.containsNode(s)) {
				return true;
			}
		} else if (root.right != null) {
			if (root.right.containsNode(s)) {
				return true;
			}
		}
		return false;
	}
//	public boolean contains(String s) {
//		if (root == null) {
//			return false;
//		} else if (root.data.compareTo(s) == 0) {
//			return true;
//		} else if (root.left == null && root.right == null){
//			return false;
//		} else if ((root.left != null && root.left.data.compareTo(s) == 0) || (root.right != null && root.right.data.compareTo(s) == 0)){
//			return true;
//		} else {
//			if (root != null && root.left != null && root.data.compareTo(s) < 0) {
//				return root.left.containsNode(s);
//			} else if (root != null && root.right != null && root.data.compareTo(s) > 0) {
//				return root.right.containsNode(s);
//			}
//		}
//		return false;
//	}
	
	public int size() {
		return size(root);
	}
	
	public int size(BST_Node node) {
		if (node == null) {
			return 0;
		} else {
			return (size(node.left) + size(node.right) + 1);
		}
	}
	
	public int height() {
		if (root == null) {
			return -1;
		}
		if (root.right == null && root.left == null) {
			return 0;
		} else if (root.right != null && root.left != null) {
			return root.getHeight();
		} else {
			if (root.right == null) {
				return root.left.getHeight() + 1;
			} else {
				return root.right.getHeight() + 1;
			}
		}
	}
}