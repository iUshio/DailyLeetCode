package dailyPromblem;

import java.util.*;

public class aimAtOffer_26 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);

        TreeNode B = new TreeNode(1);

        TreeNode tmp1 = new TreeNode(0);
        TreeNode tmp2 = new TreeNode(1);
        TreeNode tmp3 = new TreeNode(-4);
        TreeNode tmp4 = new TreeNode(-3);
        A.left = tmp1;
        A.right = tmp2;
        tmp1.left = tmp3;
        tmp1.right = tmp4;

        TreeNode tmp5 = new TreeNode(-4);
        B.left = tmp5;

        System.out.println(isSubStructure(A, B));
    }

    static TreeNode rootB;
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null && B != null || A != null && B == null) {
            return false;
        }
        if (rootB == null) {
            rootB = B;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp;
        int treeB = B.val;
        queue.add(A);
        while (!queue.isEmpty()) {
            // 层序遍历A
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                // 判断当前A节点值是否等于B的头节点值
                // 如果不等则继续遍历，相等则进行递归判定
                if (tmp.val == treeB) {
                    boolean left = B.left == null ? true : isSubStructure(tmp.left, B.left);
                    boolean right = B.right == null ? true : isSubStructure(tmp.right, B.right);
                    if (left && right) {
                        return true;
                    } else {
                        B = rootB;
                        treeB = B.val;
                        if (left) {
                            // 向左遍历
                            if (tmp.left != null) {
                                queue.add(tmp.left);
                            }
                        }
                        if(right){
                            // 向右遍历
                            if (tmp.right != null) {
                                queue.add(tmp.right);
                            }
                        }
                    }
                } else {
                    // 重置B的值为root值
                    B = rootB;
                    treeB = B.val;
                    if (tmp.left != null) {
                        queue.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.add(tmp.right);
                    }
                }

            }
        }
        return false;
    }

    // 对A进行先序遍历（recur判定该位置是否包含B结构），
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
