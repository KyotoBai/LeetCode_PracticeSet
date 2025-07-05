package BinaryTree;

public class LC_222 {
    int sum = 0;

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countNodes(root.left) + 1 + countNodes(root.right);
    }

    public static void main(String[] args) {
        LC_222 obj = new LC_222();
        Integer[] input = {1,2,3,4,5,6};
        TreeNode root = TreeNode.buildTree(input);

        System.out.print(obj.countNodes(root));
    }
}
