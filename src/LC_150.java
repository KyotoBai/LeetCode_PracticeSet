import java.util.ArrayDeque;
import java.util.Objects;

public class LC_150 {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < tokens.length; i++){
            if(Objects.equals(tokens[i], "+")){
                dq.push(dq.pop() + dq.pop());
            }else if(Objects.equals(tokens[i], "-")){
                dq.push(- dq.pop() + dq.pop());
            }else if(Objects.equals(tokens[i], "*")){
                dq.push(dq.pop() * dq.pop());
            }else if(Objects.equals(tokens[i], "/")){
                int b = dq.pop();
                int a = dq.pop();
                dq.push(a / b);
            }else{
                dq.push(Integer.parseInt(tokens[i]));
            }
        }

        return dq.peek();
    }

    public static void main(String[] args) {
        LC_150 obj = new LC_150();
        String[] input = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(obj.evalRPN(input));
    }
}
