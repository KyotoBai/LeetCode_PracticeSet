import java.util.*;

public class LC_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Too Slow
        HashMap<Integer, Integer> eleIndex = new HashMap<>();
        Set<List<Integer>> resSet = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int index1 = 0; index1 < nums.length; index1++){
            int temp = - nums[index1];
            for(int index2 = 0; index2 < nums.length; index2++){
                int temp1 = temp - nums[index2];
                if(eleIndex.containsKey(temp1)){
                    int index3 = eleIndex.get(temp1);
                    if(index1 != index2 && index1 != index3 && index2 != index3){
                        List<Integer> tempList = Arrays.asList(nums[index1], nums[index2], nums[index3]);
                        Collections.sort(tempList);
                        resSet.add(tempList);
                    }
                }
                eleIndex.put(nums[index2], index2);
            }
            eleIndex.put(nums[index1], index1);
        }

        for(List<Integer> lst: resSet){
            res.add(new ArrayList<>(lst));
        }
        return res;
         */

        /* HashSet  method
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return result;
            }

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            HashSet<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]){
                    continue;
                }

                int c = - nums[j] - nums[i];
                if(set.contains(c)){
                    result.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c);
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return result;*/

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return result;
            }

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = new int[]{-1,0,1,2,-1,-4};

        LC_15 obj = new LC_15();
        System.out.println(obj.threeSum(num));
    }
}
