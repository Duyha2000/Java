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

    // https://docs.google.com/spreadsheets/d/18Sy8ollKbTTeHBK0WkCuFMiSMTij1QZIR-y7_h5kOMU/edit?gid=0#gid=0
    static void deleteNote(Node root) {
        if (root == null) return;
        deleteNote(root.left); // trai
        deleteNote(root.right); // phai
        root.left = null; // xoa
        root.right = null;
    }

    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insert(root.left, value); // 30
        if (value > root.value) root.right = insert(root.right, value); // 70
        // 70 > 50 -> chen vao ben phai
        // root.right = null -> thay doi gia tri (70)
        // insert(null,70)
        // new Node(70);
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        postorder(root);
    }
}
