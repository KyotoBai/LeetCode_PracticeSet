public class LC_19 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int diff = 0;
        ListNode slow = head, fast = head;
        while(fast.next != null){
            fast = fast.next;
            if (diff >= n){
                slow = slow.next;
            }
            diff += 1;
        }
        if(diff < n){
            head = head.next;
        }else{
            slow.next = slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LC_19 obj = new LC_19();
        LC_19.ListNode e = obj.new ListNode(1, null);
        //LC_19.ListNode d = obj.new ListNode(2, e);
        //LC_19.ListNode c = obj.new ListNode(3, d);
        //LC_19.ListNode b = obj.new ListNode(4, c);
        //LC_19.ListNode a = obj.new ListNode(5, b);
        LC_19.ListNode nn = obj.removeNthFromEnd(e, 1);
    }
}
