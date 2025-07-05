import java.util.ArrayDeque;
import java.util.Queue;

public class LC_225 {
    class MyStack {
        ArrayDeque<Integer> queue;

        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            int size = this.queue.size();
            while(size > 1){
                queue.addLast(queue.peekFirst());
                queue.pollFirst();
                size--;
            }
            int res = queue.pollFirst();
            return res;
        }

        public int top() {
            return queue.peekLast();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
