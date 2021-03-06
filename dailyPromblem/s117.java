package dailyPromblem;

import java.util.*;

public class s117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node tmp = new Node();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                tmp.next = queue.peek();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            tmp.next = null;
        }
        return root;
    }
}
