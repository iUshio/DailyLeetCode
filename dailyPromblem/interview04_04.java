package dailyPromblem;

public class interview04_04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        return backtrace(root) == Integer.MAX_VALUE? false:true;
    }

    public int backtrace(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = backtrace(root.left) + 1;
        int right = backtrace(root.right) + 1;
        if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(left - right > 1 || right - left > 1){
            return Integer.MAX_VALUE;
        }
        return Math.max(left, right);
    }
}
