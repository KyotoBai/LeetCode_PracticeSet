package BinaryTree.BST;

public class LC_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }else if(left != null && right == null){
            return left;
        }else if(left == null && right != null){
            return right;
        }else{
            return root;
        }
    }


    public static void main(String[] args) {
        LC_236 obj = new LC_236();
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.buildTree(input);
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;

        TreeNode res = obj.lowestCommonAncestor(root, p, q);
    }
}
