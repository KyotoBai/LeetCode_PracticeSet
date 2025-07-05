import java.util.HashSet;
import java.util.Set;

public class LC_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for(int i: nums1){
            if(map1.containsKey(i)){
                map1.put(i, map1.get(i) + 1);
            }else{
                map1.put(i, 1);
            }
        }

        for(int i: nums2){
            if(map2.containsKey(i)){
                map2.put(i, map2.get(i) + 1);
            }else{
                map2.put(i, 1);
            }
        }

        int i = 0;
        int[] nums_out = new int[Math.max(nums2.length, nums1.length)];

        for(Integer k: map1.keySet()){
            if(map2.get(k) != null){
                nums_out[i++] = k;
            }
        }
        return Arrays.copyOfRange(nums_out, 0, i);*/
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for(int i: nums1){
            set.add(i);
        }

        for(int i: nums2){
            if(set.contains(i)){
                resSet.add(i);
            }
        }

        int[] resArr = new int[resSet.size()];
        int j = 0;
        for(int i: resSet){
            resArr[j++] = i;
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,4,5,6,7,10,11,24,55};
        int[] nums2 = new int[]{1,3,4,5,6,7,24,55};
        LC_349 obj = new LC_349();
        int[] out = obj.intersection(nums1, nums2);
        for(int i : out){
            System.out.print(i + " ");
        }
    }
}
