public class LC_27 {
    public int removeElement(int[] nums, int val) {
        // 普通暴力解法

        /*
        int out = nums.length;
        for(int i = 0; i < out; i++){
            if(nums[i] == val){
                for(int j = i; j < out - 1; j++){
                    nums[j] = nums[j+1];
                }
                out -= 1;
                i -= 1;
            }
        }
        return out;
         */
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n) {
            if(nums[i] != val){
                if(j < i){
                    nums[j] = nums[i];
                }
                j += 1;
            }
            i += 1;
        }
        return j;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,5,6,5,3};
        System.out.println(new LC_27().removeElement(nums, 5));
    }
}
