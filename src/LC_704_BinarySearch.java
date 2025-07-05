public class LC_704_BinarySearch {
    public int search(int[] nums, int target) {
        //binary search
        //左开右闭
        /*
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return -1;
         */

        // 左闭右闭
        // 对于array来说，区间是[0...nums.length-1]
        int left = 0, right = nums.length - 1;
        // while执行时，需要left和right组成合法的区间
        // 合法区间指的是符合左闭右闭的，比如[1,2]，但是[1,1]比较特殊，此时区间仍然合理
        // 因此选用 <= 而不是 <
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new LC_704_BinarySearch().search(nums, 9));
    }
}
