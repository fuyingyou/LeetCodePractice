package leetcode.warehouse;

public class 随机链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//
//
//        var map = new HashMap<Integer, Node>();
//        Node root = new Node(head.val);
//        Node resNode = new Node(1);
//        resNode.next = root;
//        if (map.containsKey(head.random)) {
//            return resNode.next;
//        }
//    }
}

