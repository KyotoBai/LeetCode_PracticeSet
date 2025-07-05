public class LC_977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;

        int[] out = new int[nums.length];

        for(int k = nums.length - 1; k >= 0; k--){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                out[k] = nums[i] * nums[i];
                i++;
            }else{
                out[k] = nums[j] * nums[j];
                j--;
            }
        }
        return out;
    }

    public static void main(String args[]){
        int[] nums = {-4, -1, 0, 3, 10};
        nums = new LC_977().sortedSquares(nums);
        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
