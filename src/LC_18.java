import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target && nums[i] >= 0){
                break;
            }

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] + nums[i] > target && nums[j] + nums[i] >= 0){
                    break;
                }

                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }

                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }

                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,0,-1,0,-2,2};

        LC_18 obj = new LC_18();
        System.out.println(obj.fourSum(num, 0));
    }
}
