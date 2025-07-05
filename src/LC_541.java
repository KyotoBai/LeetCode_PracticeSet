public class LC_541 {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int n = s.length();

        for(int i = 0; i < n / 2*k; i += 2*k){
            int left = i;
            int right = Math.min(n - 1, i + k - 1);

            while(left < right){
                /*
                sArr[right] ^= sArr[left];
                sArr[left] ^= sArr[right];
                sArr[right] ^= sArr[left];*/
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left += 1;
                right -= 1;
            }
        }

        return new String(sArr);
    }

    public static void main(String[] args) {
        LC_541 obj = new LC_541();
        String s = obj.reverseStr("abcdefg", 8);
        System.out.println(s);
    }
}
