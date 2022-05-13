package dailyPromblem;

public class LCP_10 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 感谢力扣大佬（小笨阁）的解析
    public double minimalExecTime(TreeNode root) {
        if (root == null)
            return 0;
        double[] res = dfs(root);
        // 最后执行时间即为总时间减去并行时间
        return res[0] - res[1];
    }

    private double[] dfs(TreeNode treeNode) {
        double[] res = new double[2];
        if (treeNode == null) {
            return res;
        }
        // 后续遍历
        double[] left = dfs(treeNode.left);
        double[] right = dfs(treeNode.right);

        double a = left[0], b = left[1], c = right[0], d = right[1];
        // res[0]表示所有任务的时间该结点
        res[0] = left[0] + right[0] + treeNode.val;
        // 以下以a > c举例,c > a的情况取反即可
        // 为保证总的时间尽可能短，应该使得并行的时间尽可能长，而总共只有双线程
        // 左侧在并行的时候右侧就不能执行，反方向上同理
        // a - 2b <= c 移动一个项--> 2b >= a - c，即左子树并行的时间大于左右子树总时间的差值
        // 这种情况下，左子树先并行执行a - c的工作，之后，左右子树的总任务时间都为c，即可并行执行两条子树上的任务
        // 总的并行时间为c + (a - c)/2
        // 2b < a - c时，左子树最后a - 2b - c的工作量无法被并行执行，总的并行时间为b + c
        if (a > c) {
            if ((a - 2 * b) < c) {
                res[1] = (a + c) / 2;
            } else {
                res[1] = b + c;
            }
        } else if (a < c) {
            if ((c - 2 * d) < a) {
                res[1] = (a + c) / 2;
            } else {
                res[1] = d + a;
            }
        } else {
            res[1] = (a + c) / 2;
        }
        return res;
    }
}
