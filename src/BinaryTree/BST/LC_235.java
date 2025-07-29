package BinaryTree.BST;

public class LC_235 {
    // recursion method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else{
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LC_235 obj = new LC_235();
        Integer[] input = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNode.buildTree(input);
        TreeNode q = root.left;
        TreeNode p = root.left.right;

        TreeNode res = obj.lowestCommonAncestor(root, p, q);

        System.out.println("answer is: " + res.val);
    }
}
