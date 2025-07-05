package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class LC_106 {
    Map<Integer, Integer> map;
    public TreeNode buildTreeHelper(int[] inOrder, int inOrderStart, int inOrderEnd, int[] postOrder, int postOrderStart, int postOrderEnd){
        if(inOrderStart >= inOrderEnd || postOrderStart >= postOrderEnd) return null;

        int rootIndex = map.get(postOrder[postOrderEnd - 1]);
        TreeNode curr = new TreeNode(inOrder[rootIndex]);

        int inOrderLeftLen = rootIndex - inOrderStart;
        curr.left = buildTreeHelper(inOrder, inOrderStart, rootIndex,
                postOrder, postOrderStart, postOrderStart + inOrderLeftLen);
        curr.right = buildTreeHelper(inOrder, rootIndex + 1, inOrderEnd,
                postOrder, postOrderStart + inOrderLeftLen, postOrderEnd - 1);
        return curr;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        LC_106 obj = new LC_106();
        TreeNode newTree = obj.buildTree(inorder, postorder);
    }
}
