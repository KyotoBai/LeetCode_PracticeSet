package BinaryTree;

public class LC_226 {
    TreeNode curr;

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        curr = root.left;
        root.left = root.right;
        root.right = curr;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        LC_226 obj = new LC_226();
        Integer[] input = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.buildTree(input);

        obj.invertTree(root);
    }
}
