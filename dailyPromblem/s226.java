package dailyPromblem;

public class s226 {
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }

        backtrace(root);
        return root;
    }

    public void backtrace(TreeNode root){
        if(root == null){
            return;
        }

        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        backtrace(root.left);
        backtrace(root.right);
        
    }
}
