package BinaryTree.BST;

public class LC_530 {
    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return  minDiff;
    }

    private void traverse(TreeNode curr){
        if(curr == null) return;

        traverse(curr.left);

        if(pre != null){
            minDiff = Math.min(minDiff, curr.val - pre.val);
        }

        pre = curr;

        traverse(curr.right);
    }

    public static void main(String[] args) {
        LC_530 obj = new LC_530();
        Integer[] arr = new Integer[]{1,0,48,null,null,12,49};
        TreeNode root = TreeNode.buildTree(arr);

        System.out.println(obj.getMinimumDifference(root));
    }
}
