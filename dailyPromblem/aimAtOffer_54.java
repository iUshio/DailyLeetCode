package dailyPromblem;

public class aimAtOffer_54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res,i;
    public int kthLargest(TreeNode root, int k) {
        i = k;
        backtrace(root);
        return res;
    }

    public void backtrace(TreeNode root){
        if(root == null){
            return;
        }

        //中序遍历
        backtrace(root.right);
        if(i == 0) return;
        i--;
        if(i == 0){
            res = root.val;
            return;
        }
        backtrace(root.left);
    }
}
