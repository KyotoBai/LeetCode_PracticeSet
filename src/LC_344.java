public class LC_344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l += 1;
            r -= 1;
        }
    }

    public static void main(String[] args) {
        LC_344 obj = new LC_344();
        char[] s = "chiar".toCharArray();
        obj.reverseString(s);
        System.out.println(s);
    }
}
