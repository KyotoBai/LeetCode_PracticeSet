import java.util.LinkedList;
import java.util.Stack;

public class LC_232 {
    class MyQueue {
        Stack<Integer> inputStack;
        Stack<Integer> outputStack;

        public MyQueue() {
            this.inputStack = new Stack<>();
            this.outputStack = new Stack<>();
        }

        public void push(int x) {
            this.inputStack.push(x);
        }

        public int pop() {
            dumpStackIn();
            return this.outputStack.pop();
        }

        public int peek() {
            dumpStackIn();
            return this.outputStack.peek();
        }

        public boolean empty() {
            return this.outputStack.isEmpty() && this.inputStack.isEmpty();
        }

        public void dumpStackIn(){
            if (!this.outputStack.isEmpty()) return;

            while(!this.inputStack.isEmpty()){
                this.outputStack.push(this.inputStack.pop());
            }
        }

    }

    public static void main(String[] args) {
        LC_232 obj = new LC_232();
        MyQueue q = obj.new MyQueue();

        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        q.empty(); 
    }
}
