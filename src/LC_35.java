public class LC_35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7};
        System.out.println(new LC_35().searchInsert(arr, 2));
    }
}
