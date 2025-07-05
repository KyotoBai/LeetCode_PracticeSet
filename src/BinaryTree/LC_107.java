package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC_107 {
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

    private List<List<Integer>> resLst = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomHelper(root, 0);
        return resLst;
    }

    private void levelOrderBottomHelper(TreeNode curr, int level){
        if (curr == null) return;

        levelOrderBottomHelper(curr.left, level + 1);
        levelOrderBottomHelper(curr.right, level + 1);

        for(int i = level + 1 - resLst.size(); i > 0; i--){
            resLst.add(0, new ArrayList<>());
        }
        resLst.get(resLst.size() - (level + 1)).add(curr.val);
    }

    public static void main(String[] args) {
        LC_107 obj = new LC_107();
        TreeNode a = obj.new TreeNode(15);
        TreeNode b = obj.new TreeNode(7);
        TreeNode c = obj.new TreeNode(20, a, b);
        TreeNode d = obj.new TreeNode(9);
        TreeNode e = obj.new TreeNode(3, d, c);

        List<List<Integer>> lst = obj.levelOrderBottom(e);
        for(List<Integer> i : lst){
            System.out.print("[");
            for(int j : i){
                System.out.print(" " + j + " ");
            }
            System.out.println("]");
        }
    }
}
