package BST;

public class BST implements BST_Interface {
    public BST_Node root;
    int size;

    public BST() {
        size = 0;
        root = null;
    }

    public BST_Node getRoot() {
        return root;
    }

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

    public String findMin() {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root.data;
        }

        return root.left.findMin().data;
    }

    public String findMax() {
        if (root == null) {
            return null;
        } else if (root.right == null) {
            return root.data;
        }

        return root.right.findMax().data;
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