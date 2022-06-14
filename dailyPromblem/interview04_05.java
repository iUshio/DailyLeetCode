package dailyPromblem;

public class interview04_05 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre = Integer.MIN_VALUE;
    int first = 0;

    public boolean isValidBST1(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        return backtrace1(root);
    }

    private boolean backtrace1(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 中序遍历
        boolean left = backtrace(root.left);
        // 处理节点
        if (first == 0) {
            first = 1;
        } else {
            if (root.val <= pre) {
                return false;
            }
        }
        pre = root.val;
        boolean right = backtrace(root.right);
        return left && right;
    }

    double inorder = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        return backtrace(root);
    }

    private boolean backtrace(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 中序遍历
        boolean left = backtrace(root.left);
        // 处理节点
        if (root.val <= inorder ) {
            return false;
        }
        inorder = root.val;
        boolean right = backtrace(root.right);
        return left && right;
    }
}
