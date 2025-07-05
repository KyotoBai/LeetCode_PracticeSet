import java.util.Deque;
import java.util.LinkedList;

public class LC_239 {
    class MyQueue{
        Deque<Integer> deque = new LinkedList<>();

        void poll(int target){
            if(!deque.isEmpty() && deque.peek() == target){
                deque.poll();
            }
        }

        void add(int x){
            while(!deque.isEmpty() && deque.getLast() < x){
                deque.removeLast();
            }
            deque.add(x);
        }

        int peek(){
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) return nums;

        int len = nums.length - k + 1;
        int[] res = new int[len];
        int numRes = 0;

        MyQueue myQueue = new MyQueue();
        for(int i = 0; i < k; i++){
            myQueue.add(nums[i]);
        }
        res[numRes++] = myQueue.peek();

        for(int i = k; i < nums.length; i++){
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[numRes++] = myQueue.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        LC_239 obj = new LC_239();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] arr2 = obj.maxSlidingWindow(arr, 3);
        for(int i: arr2){
            System.out.print(i + " ");
        }
    }
}
