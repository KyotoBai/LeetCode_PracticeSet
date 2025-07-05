public class LC_160 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null){
            nodeA = nodeA.next;
            lenA += 1;
        }
        while(nodeB != null){
            nodeB = nodeB.next;
            lenB += 1;
        }

        nodeA = headA;
        nodeB = headB;
        if (lenA >= lenB){
            for(int i = 0; i < lenA - lenB; i++){
                nodeA = nodeA.next;
            }
            while(lenB != 0){
                if(nodeA == nodeB){
                    return nodeA;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
                lenB -= 1;
            }
        }else{
            for(int i = 0; i < lenB - lenA; i++){
                nodeB = nodeB.next;
            }
            while(lenA != 0){
                if(nodeA == nodeB){
                    return nodeB;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
                lenA -= 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LC_160 obj = new LC_160();
        ListNode a = obj.new ListNode(1);
        ListNode b = obj.new ListNode(6);
        ListNode c = obj.new ListNode(8);
        ListNode d = obj.new ListNode(5);
        ListNode e = obj.new ListNode(4);
        ListNode f = obj.new ListNode(3);
        ListNode g = obj.new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        g.next = d;

        ListNode nn = obj.getIntersectionNode(a, g);
        System.out.println(nn);
    }
}
