public class TreeNode {
    // Docs:  https://docs.google.com/document/d/1tMqP4KKEb1KulbEIAvgdF87P8MCs81qP6YXm-IqbQmw/edit?tab=t.0#heading=h.ndugeuvs1kl6
    // Sheet: https://docs.google.com/spreadsheets/d/18Sy8ollKbTTeHBK0WkCuFMiSMTij1QZIR-y7_h5kOMU/edit?usp=sharing
    static class Node { // value, left,right
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " "); // in
        preorder(root.left); // di trai
        preorder(root.right); // di phai
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left); // di trai
        System.out.print(root.value + " "); // in
        inorder(root.right); // di phai
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left); // di trai
        postorder(root.right); // di phai
        System.out.print(root.value + " "); // in
    }

    static int countNodes(Node root) {
        if (root == null) return 0;
        // count++ -> trai -> phai
        int leftCount = countNodes(root.left); // 1 ->
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    static boolean searchValue(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (searchValue(root.left, value)) return true;
        if (searchValue(root.right, value)) return true; // phai
        // check -> di trai -> di phai
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        postorder(root);
    }
}
