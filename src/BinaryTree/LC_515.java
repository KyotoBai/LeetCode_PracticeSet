package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resLst = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root == null) return resLst;

        queue.offerLast(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int currMax = Integer.MIN_VALUE;

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.pollFirst();
                currMax = Math.max(currMax, node.val);

                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
            resLst.add(currMax);
        }

        return resLst;
    }

    public static void main(String[] args) {
        LC_515 obj = new LC_515();
        Integer[] input = {1,3,2,5,3,null,9};

        TreeNode root = TreeNode.buildTree(input);

        List<Integer> lst = obj.largestValues(root);
        System.out.print("[");
        for(int i : lst){
            System.out.print(" " + i + " ");
        }
        System.out.println("]");
    }
}
