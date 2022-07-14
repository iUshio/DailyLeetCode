package dailyPromblem;

public class s543 {
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

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        backtrace(root);
        return res;
    }

    private int backtrace(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = backtrace(root.left);
        int right = backtrace(root.right);
        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }

}
