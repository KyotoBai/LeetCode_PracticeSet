import java.util.HashSet;
import java.util.Set;

public class LC_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNextNumber(n);
        }
        return 1 == n;
    }

    private int getNextNumber(int n){
        int modNum;
        int sum = 0;
        while(n > 0){
            modNum = n % 10;
            sum += modNum * modNum;
            n = (n - modNum)/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC_202 obj = new LC_202();
        System.out.println(obj.isHappy(2));
    }
}
