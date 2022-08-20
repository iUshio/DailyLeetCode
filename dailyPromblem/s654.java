package dailyPromblem;

public class s654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return backtrace(nums, 0, nums.length - 1);
    }

    public TreeNode backtrace(int[] nums, int left, int right) {
        if (left == right)
            return new TreeNode(nums[left]);
        if (left > right)
            return null;

        int max = 0;
        int po = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                po = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = backtrace(nums, left, po - 1);
        root.right = backtrace(nums, po + 1, right);
        return root;
    }
}
