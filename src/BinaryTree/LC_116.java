package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class LC_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();

        if(root == null) return root;

        queue.offerLast(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                Node node = queue.pollFirst();
                if(i == levelSize - 1){
                    node.next = null;
                }else{
                    node.next = queue.peekFirst();
                }


                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
        }
        return root;
    }
}
