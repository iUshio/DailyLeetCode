package dailyPromblem;

import java.util.*;

import javafx.scene.shape.PathElementBuilder;

public class s113 {

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

    List<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        if (root == null)
            return res;
        backtrace(root, targetSum);
        return res;
    }

    private void backtrace(TreeNode root, int targetSum) {
        path.add(root.val);
        // 判断是否是根节点
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        // 先序遍历
        if (root.left != null) {
            backtrace(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            backtrace(root.right, targetSum - root.val);
        }

        path.remove(path.size() - 1);
    }
}
