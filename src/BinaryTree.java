public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        System.out.print("\nInorder: ");
//        inorder(root);
//        System.out.print("\nHeight: " + height(root));
// Gọi hàm deleteTree
//        deleteTree(root);
// 🔹 Gán root = null ở ngoài — dòng này rất quan trọng
// vì nếu không gán, biến root trong main vẫn còn trỏ đến cây
//        root = null;
        inorder(root);
    }

    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println("🖨️ In " + root.val);
        inorder(root.right);
    }

    void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // 🔍 Check theo thứ tự: Root → Left → Right ✅ (giống preorder)
    boolean search(TreeNode root, int target) {
        if (root == null) return false;           // ① Nếu cây rỗng → không có gì để tìm → false
        if (root.val == target) return true;      // ② Nếu node hiện tại là target → true
        // ③ Tìm trong nhánh trái trước (left ✅)
        if (search(root.left, target)) return true;
        // ④ Nếu chưa thấy bên trái → tìm tiếp bên phải (right ✅)
        if (search(root.right, target)) return true;
        // ⑤ Không thấy ở cả hai bên → false
        return false;
    }


    TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val); // Trường hợp 1: Gặp chỗ trống thì tạo node mới
        if (val < root.val) root.left = insert(root.left, val); // Trường hợp 2: Giá trị nhỏ hơn -> đi sang trái
        else if (val > root.val) root.right = insert(root.right, val); // Trường hợp 3: Giá trị lớn hơn -> đi sang phải
        System.out.println("Return from insert(" + root.val + ")");
        return root; // Giữ nguyên gốc (sau khi chèn xong)
    }

    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes(root.left);   // số nút ở cây con trái
        int rightCount = countNodes(root.right); // số nút ở cây con phải
        int total = 1;               // bắt đầu từ nút hiện tại
        total += leftCount;          // cộng số nút bên trái
        total += rightCount;         // cộng số nút bên phải
        return total;
    }


    static int height(TreeNode root) {
        if (root == null) return 0; // Nếu không có nút thì chiều cao là 0
        int leftHeight = height(root.left);   // chiều cao cây con bên trái
        int rightHeight = height(root.right); // chiều cao cây con bên phải
        int currentHeight = 1;                // bắt đầu tính từ nút hiện tại
        currentHeight += Math.max(leftHeight, rightHeight); // cộng chiều cao lớn hơn trong hai nhánh
        return currentHeight; // trả về chiều cao của cây hiện tại
    }

    static void clearTree(TreeNode root) {
        if (root == null) return; // Cây rỗng → không làm gì
        clearTree(root.left); // 1. Xóa nhánh trái trước
        clearTree(root.right); // 2. Xóa nhánh phải sau
        // 3. Cắt liên kết của nút hiện tại
        root.left = null;
        root.right = null;
    }
}