import java.util.HashMap;

public class LC_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            int otherNum = target - nums[i];
            if(otherNum >= 0 && map.containsKey(otherNum)){
                res[0] = i;
                res[1] = map.get(otherNum);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 0};
        LC_1 obj = new LC_1();
        nums = obj.twoSum(nums, 0);
        System.out.println("the output is: " + nums[0] + " and " + nums[1]);
    }
}
