package BST;

public class BST_Playground {

    public static void main(String[] args) {

        BST finalTest = new BST();
        String[] s = {
            "D",
            "X",
            "I",
            "S",
            "B",
            "Y",
            "F",
            "T",
            "V",
            "M",
            "C",
            "Q",
            "O",
            "H",
            "W",
            "E",
            "U",
            "A",
            "J",
            "R",
            "K",
            "N",
            "Z",
            "P",
            "G",
            "L"
        };
        for (int i = 0; i < s.length; i++) {
            finalTest.insert(s[i]);
        }


        printLevelOrder(finalTest);
        System.out.println();
        printInOrder(finalTest.root);
    }

    static void printLevelOrder(BST tree) {
        int h = tree.getRoot().getHeight();
        for (int i = 0; i <= h; i++) {
            printGivenLevel(tree.getRoot(), i);
        }

    }
    static void printGivenLevel(BST_Node root, int level) {
        if (root == null) return;
        if (level == 0) System.out.print(root.data + " ");
        else if (level > 0) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
    static void printInOrder(BST_Node root) {
        if (root != null) {
            printInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            printInOrder(root.getRight());
        }
    }
}