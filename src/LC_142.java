public class LC_142 {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //cycle detect
        while(fast.next != null && fast.next.next != null){
            if(fast != head && fast == slow){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == null){
            return new ListNode(-1);
        }
        /**
         * List model:
         *      a -> b -> c -> d -> e -> f
         *                |              |
         *                <--------------<
         *
         * 循环 : c to f
         * x = head到 循环入口 : a to c
         *
         * slow和fast的相遇点 e
         * 循环入口 到 相遇点e 的距离是 y = c -> e
         * 相遇点e 到 循环入口是 z = e -> c
         *
         * slow = x + y
         * fast = x + y + (z + y) * n, n为fast在 cycle内走过的圈数
         * fast每走2 step, slow走1 step
         *
         * 2*(x + y) = x + y + n * (z + y)
         * x + y = n * (z + y)
         * x = n * (z + y) - y
         * x = (n - 1) * (z + y) + z 其中 z + y 是一个cycle, n>=1
         *
         * if n = 1, x = z
         * 从相遇点e开始一个ptr,同时从head开始一个ptr，两者相遇时应该就是cycle的起点
         */
        slow = head;
        int steps = 0;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            steps += 1;
        }
        return new ListNode(steps);
    }

    public static void main(String[] args) {
        LC_142 obj = new LC_142();
        ListNode a = obj.new ListNode(3);
        ListNode b = obj.new ListNode(2);
        ListNode c = obj.new ListNode(0);
        ListNode d = obj.new ListNode(-4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(obj.detectCycle(a).val);
    }
}
