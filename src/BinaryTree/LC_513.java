package BinaryTree;

public class LC_513{
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueHelper(root, 0);
        return res;
    }

    int res = 0;
    int maxDepth = Integer.MIN_VALUE;

    private void findBottomLeftValueHelper(TreeNode curr, int depth){
        if(curr == null) return;

        if(curr.left == null && curr.right == null){
           if(depth > maxDepth) {
               maxDepth = depth;
               res = curr.val;
           }
           return;
        }

        findBottomLeftValueHelper(curr.left, depth + 1);
        findBottomLeftValueHelper(curr.right, depth + 1);
    }

    public static void main(String[] args) {
        LC_513 obj = new LC_513();
        Integer[] input = {1,2,3,4,null,5,6,null,null,7};

        TreeNode root = TreeNode.buildTree(input);

        System.out.println(obj.findBottomLeftValue(root));
    }
}
