package dailyPromblem;

import java.util.*;

public class s297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 层序遍历
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node != null) {
                builder.append(node.val);
                stack.offer(node.left);
                stack.offer(node.right);
            } else
                builder.append("#");
            builder.append(",");
        }
        return builder.toString();
    }

    // 依据层序遍历结果构建树
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        if (splits[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < splits.length; ++i) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            if (!splits[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(splits[i++]));
                queue.offer(node.left);
            } else
                ++i;
            if (!splits[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(splits[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
