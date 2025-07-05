package BinaryTree.BST;

import java.util.ArrayList;
import java.util.List;

public class LC_501 {
    List<Integer> res = new ArrayList<>();
    int maxcount = 0;
    int count = 0;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        inorderTraverse(root);
        int[] resArr = new int[res.size()];
        for(int i = 0; i < resArr.length; i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }


    public void inorderTraverse(TreeNode curr){
        if(curr == null) return;

        inorderTraverse(curr.left);

        if(pre == null || pre.val != curr.val){
            count = 1;
        }else{
            count++;
        }

        if(count > maxcount){
            res.clear();
            res.add(curr.val);
            maxcount = count;
        }else if(count == maxcount){
            res.add(curr.val);
        }
        pre = curr;

        inorderTraverse(curr.right);
    }

    public static void main(String[] args) {
        LC_501 obj = new LC_501();
        Integer[] input = {1,null,2,2};

        TreeNode root = TreeNode.buildTree(input);

        int[] res = obj.findMode(root);
    }
}
