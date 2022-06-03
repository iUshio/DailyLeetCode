package dailyPromblem;

import java.util.*;;

public class s429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path;

        if (root == null) {
            return res;
        }

        int size = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tmp;
        while (!queue.isEmpty()) {
            size = queue.size();
            path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                path.add(tmp.val);
                for (Node a : tmp.children) {
                    queue.add(a);
                }
            }
            res.add(path);
        }

        return res;
    }
}
