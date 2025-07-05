public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid;
                right = mid;
                while(nums[left] == target){
                    left -= 1;
                    if(left < 0) break;
                }

                while(nums[right] == target){
                    right += 1;
                    if(right > nums.length - 1) break;
                }

                return new int[]{left + 1, right - 1};
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return new int[]{-1, -1};
    }
}
