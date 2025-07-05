package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC_117 {
    List<Node> levels = new ArrayList<>();

    public Node connect(Node root) {
        connectHelper(root, 0);
        return root;
    }

    private void connectHelper(Node curr, int level){
        if(curr == null) return;

        if(level > levels.size() - 1) {
            levels.add(level, curr);
        }else{
            levels.get(level).next = curr;
            levels.set(level, curr);
        }

        connectHelper(curr.left, level + 1);
        connectHelper(curr.right, level + 1);
    }

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
    }
}
