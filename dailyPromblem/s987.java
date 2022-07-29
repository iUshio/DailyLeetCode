package dailyPromblem;

import java.util.*;

public class s987 {

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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();

        dfs(root, 0, 0, nodes);
        // 通过row进行排序
        Collections.sort(nodes, new Comparator<int[]>() {
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    // 按列排序
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    // 同列按照层级排序
                    return tuple1[1] - tuple2[1];
                } else {
                    // 同列同层按照大小排序
                    return tuple1[2] - tuple2[2];
                }
            }
        });

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;

        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            // 到了新的一层
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }

        return ans;
    }

    public void dfs(TreeNode node, int row, int col, List<int[]> nodes) {

        if (node == null) {
            return;
        }

        nodes.add(new int[] { col, row, node.val });
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }

}
