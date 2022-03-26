package dailyPromblem;

public class s150 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bactrace(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode bactrace(int[] preorder, int preleft, int preright,
            int[] inorder, int inleft, int inright) {
        
        if(preright < preleft){
            return null;
        }
        if (preleft == preright) {
            return new TreeNode(preorder[preright]);
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        
        int index = 0;
        for(int i = inleft;i <= inright;i++){
            if(preorder[preleft] == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = bactrace(preorder, preleft + 1, preleft + (index - inleft), inorder, inleft, index - 1);
        root.right = bactrace(preorder, preleft + (index - inleft + 1), preright, inorder, index + 1, inright);

        return root;
    }
}
