package dailyPromblem;

public class s1302 {
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
    int deep = 1;

    public int deepestLeavesSum(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }

        backtrace(root, 1);
        return res;
    }

    private void backtrace(TreeNode root, int curDeep) {
        if (root == null) {
            return;
        }

        // 判断当前深度与统计的深度
        if (deep == curDeep) {
            // 累加和
            res += root.val;
        } else if (deep < curDeep) {
            // 重置res，deep
            deep = curDeep;
            res = root.val;
        }
        backtrace(root.left, curDeep + 1);
        backtrace(root.right, curDeep + 1);
    }
}
