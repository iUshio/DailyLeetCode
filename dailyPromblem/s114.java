package dailyPromblem;

public class s114 {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 处理先序遍历节点
        if (root.left != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            if (right != null) {
                // 将原本的右节点添加到left的最深层的右节点
                TreeNode tmp = root.right;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = right;
            }
        }
        // 处理之后root节点左边必定为空，直接向右进行访问
        flatten(root.right);
    }

    private void backtrace(TreeNode root) {
        if (root == null) {
            return;
        }

        // 处理先序遍历节点
        if (root.left != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            if (right != null) {
                // 将原本的右节点添加到left的最深层的右节点
                TreeNode tmp = root.right;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = right;
            }
        }
        // 处理之后root节点左边必定为空，直接向右进行访问
        backtrace(root.right);
    }
}
