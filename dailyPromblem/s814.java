package dailyPromblem;

public class s814 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(1)));
        pruneTree(root);
    }

    public static class TreeNode {
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

    public static TreeNode pruneTree(TreeNode root) {
        return backtrace(root) ? root : null;

    }

    private static boolean backtrace(TreeNode root) {
        if (root == null)
            return false;

        boolean left = backtrace(root.left);
        boolean right = backtrace(root.right);
        // 左子树不包含1，直接删除
        if (left == false)
            root.left = null;
        // 右子树不包含1，直接删除
        if (right == false)
            root.right = null;
        // 如果左右子树都不包含1且该节点的值为0，父结点应该删除改节点所在的子树
        return root.left != null || root.right != null || root.val == 1;
    }
}
