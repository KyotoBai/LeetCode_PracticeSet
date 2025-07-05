import java.util.Stack;

public class LC_20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < n ; i++){
            if(s.charAt(i) == '('){
                stk.push(')');
            }else if(s.charAt(i) == '['){
                stk.push(']');
            }else if(s.charAt(i) == '{'){
                stk.push('}');
            }else if(stk.isEmpty() || s.charAt(i) != stk.peek()){
                return false;
            }else{
                stk.pop();
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {
        LC_20 obj = new LC_20();
        System.out.println(obj.isValid("[{[()]}]"));
    }
}
