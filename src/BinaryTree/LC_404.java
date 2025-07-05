package BinaryTree;

public class LC_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, 'r');
    }

    private int sumOfLeftLeavesHelper(TreeNode curr, char branch){
        if (curr == null) return 0;

        if (curr.left == null && curr.right == null){
            return branch == 'l'? curr.val: 0;
        }
        return sumOfLeftLeavesHelper(curr.left, 'l') + sumOfLeftLeavesHelper(curr.right, 'r');
    }

    public static void main(String[] args) {
        LC_404 obj = new LC_404();
        Integer[] input = {1,2,3,4,5};

        TreeNode root = TreeNode.buildTree(input);

        System.out.println(obj.sumOfLeftLeaves(root));
    }
}
