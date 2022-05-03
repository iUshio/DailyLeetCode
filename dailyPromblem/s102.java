package dailyPromblem;

import java.util.*;

public class s102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        List<Integer> path;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()){
            path = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size;i++){
                tmp = queue.poll();
                path.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            res.add(path);
        }

        return res;
    }
}
