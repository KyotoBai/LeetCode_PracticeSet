package BinaryTree.BST;

public class LC_701 {
    public TreeNode insertIntoBST(TreeNode root, int n) {
        if(root == null) return new TreeNode(n);

        if(n < root.val){
            root.left = insertIntoBST(root.left, n);
        }else{
            root.right = insertIntoBST(root.right, n);
        }
        return root;
    }

    public static void main(String[] args) {
        LC_701 obj = new LC_701();
        Integer[] input = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNode.buildTree(input);
        TreeNode p = new TreeNode(1);

        TreeNode res = obj.insertIntoBST(root, p.val);

        System.out.println("answer is: " + res.left.left.right.val);
    }
}
