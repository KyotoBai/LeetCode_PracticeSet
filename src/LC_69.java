public class LC_69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }

        int left = 1, right = x;

        while (left <= right){
            int mid = left + (right - left)/2;
            if ( (long)mid * mid >  (long)x){
                right = mid - 1;
            }else if (mid * mid == x){
                return mid;
            } else if(mid * mid < x){
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new LC_69().mySqrt(8));
    }
}
