package dailyPromblem;

import java.util.LinkedList;
import java.util.Queue;

public class s109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    // 思路：bfs建树保证高度差不超过1，dfs中序遍历保证搜索树
    ListNode list;

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        list = head;
        head = head.next;
        TreeNode root = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (head != null) {
            TreeNode tmp = queue.poll();
            tmp.left = new TreeNode();
            queue.add(tmp.left);
            // 移动list
            head = head.next;
            if (head == null) {
                break;
            }
            tmp.right = new TreeNode();
            queue.add(tmp.right);
            head = head.next;
        }
        dfs1(root);
        return root;
    }

    // 中序遍历
    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs1(root.left);
        // 处理节点
        root.val = list.val;
        list = list.next;
        dfs1(root.right);
    }

}
