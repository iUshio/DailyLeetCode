package dailyPromblem;

import java.util.*;

public class s662 {
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

    // 超时
    public int widthOfBinaryTree1(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int res = 1;
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int tmplen = 0;
            TreeNode tmp;
            for(int i = 0; i < size; i++){
                tmp = queue.poll();
                // 计算宽度
                if(tmp == null){
                    // 分几种情况
                    // 如果tmplen == 0，左边必须不为空才可以开始记数
                    // 如果tmplen != 0，可以记数
                    if(tmplen != 0){
                        tmplen++;
                    }
                    queue.add(null);
                    queue.add(null);
                }else{
                    tmplen++;
                    // 更新res
                    res = res > tmplen? res:tmplen;
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }

            }
            if(tmplen == 0){
                // 当前层宽度为0即无结点
                break;
            }
        }
        return res;
    }

    public int widthOfBinaryTree(TreeNode root) {
        // 如果结点为空，则宽度为0
        if(root == null) {
            return 0;
        }
        // 记录最大宽度
        int width = 0;
        // 队列1，放入TreeNode结点
        Deque<TreeNode> queue1 = new LinkedList<>();
        // 队列2，放入结点的位置索引
        Deque<Integer> queue2 = new LinkedList<>();
        // 放入root结点
        queue1.offerLast(root);
        // 放入root结点的位置索引
        queue2.offerLast(1);
        while(!queue1.isEmpty()) {
            // 当前层的结点数量
            int size = queue1.size();
            // 记录当前层的最大宽度
            int tmpWidth = 0;
            // 用于判断是否为当前层的第一个结点
            boolean flag = false;
            int left = -1, right = -1;
            // 遍历当前层的所有结点
            while(size-- > 0) {
                TreeNode node = queue1.pollFirst();
                int pos = queue2.pollFirst();
                // 遇到第一个结点
                if(!flag) {
                    flag = true;
                    left = pos;
                }
                right = pos;
                // 不停更新当前层的最大宽度
                tmpWidth = Math.max(tmpWidth, right-left+1);
                if(node.left != null) {
                    queue1.offerLast(node.left);
                    queue2.offerLast(pos*2);
                }
                if(node.right != null) {
                    queue1.offerLast(node.right);
                    queue2.offerLast(pos*2+1);
                }
            }
            width = Math.max(width, tmpWidth);
        }
        return width;
    }

}
