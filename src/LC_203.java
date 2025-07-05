

public class LC_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        head.next = removeElements(head.next, val);
        if (head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

    public static void main(String[] args) {
        LC_203 obj = new LC_203();
        ListNode e = obj.new ListNode(5, null);
        ListNode d = obj.new ListNode(5, e);
        ListNode c = obj.new ListNode(5, d);
        ListNode b = obj.new ListNode(5, c);
        ListNode a = obj.new ListNode(5, b);

        ListNode out = obj.removeElements(a, 5);

        while(out != null){
            System.out.print(out.val + " ");
            out = out.next;
        }
    }
}

