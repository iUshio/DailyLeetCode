package dailyPromblem;

public class s236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        backtrace(root, p, q);
        return res;
    }

    public boolean backtrace(TreeNode root, TreeNode p, TreeNode q) {
        // 访问到头了
        if (root == null) {
            return false;
        }
        // 判断自身、左孩子、右孩子是否有目标节点
        boolean mid = root == p || root == q;
        boolean left = backtrace(root.left, p, q);
        boolean right = backtrace(root.right, p, q);
        // 遇到第一个节点，该结点左右孩子或自身包含了两个目标结点
        if ((mid && left) || (mid && right) || (left && right)) {
            res = root;
        }
        // 向上传递目标节点发现情况（只有两节点且不重复）
        if (mid || left || right) {
            return true;
        }
        // 改节点下一个目标节点都没有
        return false;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 直接返回目标节点或空节点
        if (root == null || root.val == p.val ||root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 左右孩子发现目标节点
        if (left != null && right != null) return root;
        // 左孩子包含目标节点
        else if (left == null && right != null) return right;
        // 有孩子发现目标节点
        else if (left != null && right == null) return left;
        // 左右都没有发现
        else return null;
    }
}
