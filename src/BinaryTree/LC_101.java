package BinaryTree;

public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compareNode(root.left, root.right);
    }

    private boolean compareNode(TreeNode left, TreeNode right){
        //终止条件
        if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        else if(left == null && right == null) return true;
        else if(left.val != right.val) return false;

        boolean leftsub = compareNode(left.left, right.right);
        boolean rightsub = compareNode(left.right, right.left);
        boolean isSame = leftsub && rightsub;

        return isSame;
    }

    public static void main(String[] args) {

    }
}
