import java.util.Stack;

public class LC_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stk.isEmpty() && stk.peek() == s.charAt(i)){
                stk.pop();
                continue;
            }
            stk.push(s.charAt(i));
        }

        char[] carr = new char[stk.size()];
        for(int i = carr.length - 1; i >= 0; i--){
            carr[i] = stk.pop();
        }

        return new String(carr);
    }

    public static void main(String[] args) {
        LC_1047 obj = new LC_1047();
        System.out.println(obj.removeDuplicates("azxxzy"));
    }
}
