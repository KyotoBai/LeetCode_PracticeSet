package BinaryTree;

public class LC_104 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        LC_104 obj = new LC_104();
        Integer[] input = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTree(input);

        System.out.print(obj.maxDepth(root));
    }
}
