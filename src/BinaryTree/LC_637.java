package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC_637 {
    List<Double> resLst = new ArrayList<>();
    List<Integer> numsEachLevel = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        levelOrderHelper(root, 0);
        for(int i = 0; i < resLst.size(); i++){
            resLst.set(i, resLst.get(i) / numsEachLevel.get(i));
        }
        return resLst;
    }

    private void levelOrderHelper(TreeNode curr, int level){
        if (curr == null) return;

        while(level + 1 > resLst.size()){
            resLst.add(0.0);
            numsEachLevel.add(0);
        }

        resLst.set(level, resLst.get(level) + curr.val);
        numsEachLevel.set(level, numsEachLevel.get(level) + 1);
        levelOrderHelper(curr.left, level + 1);
        levelOrderHelper(curr.right, level + 1);
    }

    public static void main(String[] args) {
        LC_637 obj = new LC_637();
        Integer[] input = {3,9,20,15,7};
        TreeNode root = TreeNode.buildTree(input);

        List<Double> lst = obj.averageOfLevels(root);
        System.out.print("[");
        for(double i : lst){
            System.out.print(" " + i + " ");
        }
        System.out.println("]");
    }
}
