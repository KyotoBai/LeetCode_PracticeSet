package BinaryTree.BST;

public class LC_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else if (root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            if (root.left == null && root.right == null){
                return null;
            }else if (root.left != null && root.right == null){
                return root.left;
            }else if (root.left == null && root.right != null){
                return root.right;
            }else{
                TreeNode curr = root.right;
                while(curr.left != null){
                    curr = curr.left;
                }
                curr.left = root.left;
                root = root.right;
                return  root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LC_450 obj = new LC_450();
        Integer[] input = {5,3,6,2,4,null,7};
        TreeNode root = TreeNode.buildTree(input);

        TreeNode res = obj.deleteNode(root, 3);

    }
}
