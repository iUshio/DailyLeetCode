package dailyPromblem;

import java.util.*;

public class s103 {
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

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path;
        // 通过stack实现交叉遍历
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackTmp;
        stack.push(root);
        TreeNode tmp;
        // 标识方向，true表示从左往右，false表示从右往左
        boolean direction = true;
        while (!stack.isEmpty()) {
            path = new LinkedList<>();
            stackTmp = new Stack<>();
            // 遍历每一层节点
            while(!stack.isEmpty()){
                tmp = stack.pop();
                path.add(tmp.val);
                if (direction) {
                    // 应该从左往右访问
                    if (tmp.left != null) {
                        stackTmp.push(tmp.left);
                    }
                    if (tmp.right != null) {
                        stackTmp.push(tmp.right);
                    }
                } else {
                    if (tmp.right != null) {
                        stackTmp.push(tmp.right);
                    }
                    if (tmp.left != null) {
                        stackTmp.push(tmp.left);
                    }
                }
            }
            stack = stackTmp;
            // 方向位取反
            direction = !direction;
            res.add(new ArrayList<>(path));
        }

        return res;
    }

    // 隔行反转
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (reverse) {
                Collections.reverse(tempList);
            }
            reverse = !reverse;
            ans.add(tempList);
        }
        return ans;
    }

}
