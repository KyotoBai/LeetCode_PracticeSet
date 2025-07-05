package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC_102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        levelOrderHelper(root, 0, lst);
        return lst;
    }

    private void levelOrderHelper(TreeNode curr, int level, List<List<Integer>> lst){
        if (curr == null) return;

        if (lst.size() == level) {
            lst.add(new ArrayList<>());
        }
        lst.get(level).add(curr.val);
        levelOrderHelper(curr.left, level + 1, lst);
        levelOrderHelper(curr.right, level + 1, lst);
    }

    public static void main(String[] args) {
        LC_102 obj = new LC_102();
        TreeNode a = obj.new TreeNode(15);
        TreeNode b = obj.new TreeNode(7);
        TreeNode c = obj.new TreeNode(20, a, b);
        TreeNode d = obj.new TreeNode(9);
        TreeNode e = obj.new TreeNode(3, d, c);

        List<List<Integer>> lst = obj.levelOrder(e);
        for(List<Integer> i : lst){
            System.out.print("[");
            for(int j : i){
                System.out.print(" " + j + " ");
            }
            System.out.println("]");
        }
    }
}
