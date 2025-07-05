package BinaryTree.BST;

public class LC_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val == val) return root;
        if(root.val > val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        LC_700 obj = new LC_700();
        Integer[] arr = new Integer[]{4,2,7,1,3};
        TreeNode root = TreeNode.buildTree(arr);

        TreeNode res = obj.searchBST(root, 2);
    }
}
