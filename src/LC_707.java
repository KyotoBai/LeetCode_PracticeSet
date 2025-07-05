public class LC_707 {
    class MyLinkedList {
        class Node {
            int val;
            Node next;

            public Node(int val){
                this.val = val;
                this.next = null;
            }
        }

        private Node head;
        private int list_size;

        public MyLinkedList() {
            this.head = new Node(0);
            this.list_size = 0;
        }

        public int get(int index) {
            if (index >= this.list_size) return -1;

            Node curr = head;
            for(;index >= 0; index--){
                curr = curr.next;
            }

            return curr.val;
        }

        public void addAtHead(int val) {
            Node n = new Node(val);
            n.next = head.next;
            head.next = n;
            this.list_size += 1;
        }

        public void addAtTail(int val) {
            Node curr = head;
            int index = this.list_size - 1;
            for(;index >= 0; index--){
                curr = curr.next;
            }
            curr.next = new Node(val);
            this.list_size += 1;
        }

        public void addAtIndex(int index, int val) {
            if (index > this.list_size) return;
            Node pre = head;
            for(; index > 0; index--){
                pre = pre.next;
            }
            Node new_node = new Node(val);
            new_node.next = pre.next;
            pre.next = new_node;
            this.list_size += 1;
        }

        public void deleteAtIndex(int index) {
            if (index >= this.list_size || this.list_size == 0) return;
            Node pre = head;
            for(; index > 0; index--){
                pre = pre.next;
            }
            pre.next = pre.next.next;
            this.list_size -= 1;
        }
    }

    public static void main(String[] args) {
        LC_707 obj = new LC_707();
        MyLinkedList list = obj.new MyLinkedList();
        String[] operation = {"MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"};
        int[][] value = {
                {},       // Empty array
                {4},
                {1},
                {1},
                {5},
                {3},
                {7},
                {3},
                {3},
                {3},
                {1},
                {4}
        };
        for(int i = 1; i < operation.length; i++){
            switch (operation[i]){
                case "addAtHead":
                    list.addAtHead(value[i][0]);
                    break;

                case "get":
                    System.out.println(list.get(value[i][0]));
                    break;

                case "addAtTail":
                    list.addAtTail(value[i][0]);
                    break;

                case "addAtIndex":
                    list.addAtIndex(value[i][0], value[i][1]);
                    break;

                case "deleteAtIndex":
                    list.deleteAtIndex(value[i][0]);
                    break;
            }
        }
    }
}
