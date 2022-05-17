package dailyPromblem;

public class s538 {
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

    TreeNode pre = new TreeNode();
    public TreeNode convertBST(TreeNode root) {
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

        // 反方向中序遍历
        backtrace(root.right);
        if(pre == null){
            // 访问到最右边的结点，结点值不做改变
            pre = root;
        }else{
            // 该结点值为上一个结点的值加上本结点的值
            root.val += pre.val;
            // 更新pre
            pre = root;
        }
        backtrace(root.left);
    }
}
