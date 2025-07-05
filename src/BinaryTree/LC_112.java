package BinaryTree;

public class LC_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(targetSum == root.val && root.left == null && root.right == null){
            return true;
        }

        int newSum = targetSum - root.val;

        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }

    public static void main(String[] args) {
        LC_112 obj = new LC_112();
        Integer[] input = {5,4,8,11,null,13,4,7,2,null,null,null,1};

        TreeNode root = TreeNode.buildTree(input);

        System.out.println(obj.hasPathSum(root, 22));
    }
}
