package BinaryTree;

public class LC_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode curr){
        if(curr == null) return 0;
        int leftHeight = getHeight(curr.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(curr.right);
        if(rightHeight == -1) return -1;

        return Math.abs(leftHeight - rightHeight) > 1? -1: Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        LC_110 obj = new LC_110();
        Integer[] input = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTree(input);

        System.out.print(obj.isBalanced(root));
    }
}
