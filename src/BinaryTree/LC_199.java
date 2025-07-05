package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_199 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Process left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Process right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    private List<Integer> resLst = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root, 0);
        return resLst;
    }

    private void rightSideViewHelper(TreeNode curr, int level){
        if(curr == null) return;

        rightSideViewHelper(curr.right, level + 1);
        rightSideViewHelper(curr.left, level + 1);

        for(int i = level - resLst.size() + 1; i > 0; i--){
            resLst.add(Integer.MIN_VALUE);
        }
        if(resLst.get(level) == Integer.MIN_VALUE){
            resLst.set(level, curr.val);
        }
    }

    public static void main(String[] args) {
        LC_199 obj = new LC_199();
        Integer[] input = {1,2,0};
        TreeNode root = obj.buildTree(input);

        List<Integer> lst = obj.rightSideView(root);
        System.out.print("[");
        for(int i : lst){
            System.out.print(" " + i + " ");
        }
        System.out.println("]");
    }
}
