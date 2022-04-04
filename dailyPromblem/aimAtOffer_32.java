package dailyPromblem;

import java.util.*;

public class aimAtOffer_32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        boolean forward = true;//false代表先右后左
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> path = new LinkedList<>();
            // 遍历当前一层的结点
            for(int i = 0; i < size;i++){
                TreeNode tmp = queue.poll();
                path.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            if(!forward){
                Collections.reverse(path);
            }
            forward = !forward;
            res.add(new ArrayList(path));
        }
        return res;
    }
}
