package dailyPromblem;

import java.util.*;

public class aimAtOffer_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        Node head = null;
        Node pre = null;
        Node tmp = root;
        Stack<Node> stack = new Stack<>();
        while(tmp != null || !stack.isEmpty()){
            if(tmp != null){
                stack.add(tmp);
                tmp = tmp.left;
            }else{
                tmp = stack.pop();
                if(head == null){
                    head = tmp;
                    pre = head;
                }else{
                    pre.right = tmp;
                    tmp.left = pre;
                    pre = tmp;
                }
                tmp = tmp.right;
            }
        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    // 较好解法（网上）
    Node pre, head;
    public Node treeToDoublyList2(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
