package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return arr;
        if(root.right == null && root.left == null) {
            arr.add(Integer.toString(root.val));
            return arr;
        }
        findPaths(root, "");
        return arr;
    }

    List<String> arr = new ArrayList<>();

    private void findPaths(TreeNode curr, String currPath){
        if (curr == null) return;

        if (curr.left == null && curr.right == null) {
            arr.add(currPath.concat("->" +curr.val));
            return;
        }else{
            if (currPath.equals("")){
                currPath = currPath.concat(Integer.toString(curr.val));
            }else{
                currPath = currPath.concat("->" + curr.val);
            }
        }

        findPaths(curr.left, currPath);
        findPaths(curr.right, currPath);
    }

    public static void main(String[] args) {
        LC_257 obj = new LC_257();
        Integer[] input = {};
        TreeNode root = TreeNode.buildTree(input);

        System.out.println(obj.binaryTreePaths(root));
    }
}
