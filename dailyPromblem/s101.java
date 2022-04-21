package dailyPromblem;

public class s101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        return backtrace(root.left, root.right);
    }

    public boolean backtrace(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left != null && right == null) ||
                (left == null && right != null) ||
                left.val != right.val) {
            return false;
        }
        // 比较外层
        boolean out = backtrace(left.left, right.right);
        // 比较内层
        boolean in = backtrace(left.right, right.left);

        return out & in;
    }
}
