package dailyPromblem;



public class s98 {
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

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(-1);
        TreeNode s2 = new TreeNode(0,s1,null);
        isValidBST(s2);
    }


    static TreeNode pre;
    public static boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }

        // 中序遍历
        return bactrace(root);
    }

    public static boolean bactrace(TreeNode root){
        if(root == null){
            return true;
        }

        boolean left = bactrace(root.left);
        // 处理节点
        if(pre != null){
            if(root.val <= pre.val){
                return false;
            }
        }
        pre = root;
        boolean right = bactrace(root.right);

        return left & right;
    }
}
