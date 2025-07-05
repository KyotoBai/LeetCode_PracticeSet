package BinaryTree;

public class LC_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;

        if(root2 != null && root1 == null){
            return root2;
        }else if(root1 != null && root2 == null){
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1,3,2,5};
        TreeNode root1 = TreeNode.buildTree(arr1);
        Integer[] arr2 = new Integer[]{2,1,3,null,4,null,7};
        TreeNode root2 = TreeNode.buildTree(arr2);

        LC_617 obj = new LC_617();
        TreeNode newroot = obj.mergeTrees(root1, root2);
    }
}
