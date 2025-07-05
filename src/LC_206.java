public class LC_206 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LC_206 obj = new LC_206();
        ListNode e = obj.new ListNode(1, null);
        ListNode d = obj.new ListNode(2, e);
        ListNode c = obj.new ListNode(3, d);
        ListNode b = obj.new ListNode(4, c);
        ListNode a = obj.new ListNode(5, b);
        obj.reverseList(a);
    }
}
