package BinaryTree;

public class LC_111 {
    public int minDepth(TreeNode root){
        if (root == null) return 0;

        if (root.left == null){
            return minDepth(root.right) + 1;
        }
        if (root.right == null){
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        LC_111 obj = new LC_111();
        Integer[] input = {2,null,3,null,4,null,5,null,6};
        TreeNode root = TreeNode.buildTree(input);

        System.out.print(obj.minDepth(root));
    }
}
