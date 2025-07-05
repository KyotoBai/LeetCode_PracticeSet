public class LC_24 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head, right = head.next;
        left.next = swapPairs(right.next);
        right.next = left;
        return right;
    }

    public static void main(String[] args) {
        LC_24 obj = new LC_24();
        LC_24.ListNode e = obj.new ListNode(1, null);
        LC_24.ListNode d = obj.new ListNode(2, e);
        LC_24.ListNode c = obj.new ListNode(3, d);
        LC_24.ListNode b = obj.new ListNode(4, c);
        LC_24.ListNode a = obj.new ListNode(5, b);
        obj.swapPairs(a);
    }
}



