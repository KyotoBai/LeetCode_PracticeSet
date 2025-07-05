public class LC_209 {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        int curr_max = 0, min_len = Integer.MAX_VALUE;
        int start = 0;
        for(int end = 0; end < nums.length; end++){
            curr_max += nums[end];
            if (curr_max >= target){
                min_len = Math.min(min_len, end - start + 1);
                while(curr_max - nums[start] >= target){
                    curr_max -= nums[start];
                    start += 1;
                }
                min_len = Math.min(min_len, end - start + 1);
            }
        }
        if(min_len == Integer.MAX_VALUE){
            return 0;
        }else{
            return min_len;
        }
        */

        //双指针 组成的滑动窗口
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < nums.length; right++){
            sum += nums[right];

            if(sum >= target){
                while(sum - nums[left] >= target){
                    sum -= nums[left++];
                }
                len = Math.min(len, right - left + 1);
            }
        }
        return len == Integer.MAX_VALUE? 0: len;
    }

    public static void main(String args[]){
        int[] nums = {4, 1, 1, 3, 3};

        System.out.println(new LC_209().minSubArrayLen(6, nums));
    }
}
