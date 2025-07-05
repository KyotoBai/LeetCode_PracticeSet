package BinaryTree;

public class LC_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTreeHelper(int[] nums, int left, int right){
        if(left >= right){
            return null;
        }

        int maxIndex = left, maxValue = Integer.MIN_VALUE;
        for(int i = left; i < right; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode curr = new TreeNode(maxValue);
        curr.left = constructMaximumBinaryTreeHelper(nums, left, maxIndex);
        curr.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, right);
        return curr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,6,0,5};

        LC_654 obj = new LC_654();
        TreeNode curr = obj.constructMaximumBinaryTree(arr);
    }
}
