package BinaryTree.BST;

public class LC_98 {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        boolean left = isValidBST(root.left);
        if(!left){
            return false;
        }

        if (max != null && root.val <= max.val) {
            return false;
        }

        max = root;

        boolean right = isValidBST(root.right);
        return right;
    }

    public static void main(String[] args) {
        LC_98 obj = new LC_98();
        Integer[] arr = new Integer[]{5,4,6,null,null,3,7};
        TreeNode root = TreeNode.buildTree(arr);

        boolean bool = obj.isValidBST(root);
    }
}
