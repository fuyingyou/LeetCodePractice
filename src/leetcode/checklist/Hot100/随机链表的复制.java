package leetcode.checklist.Hot100;

import leetcode.common.Node;

import java.util.HashMap;

public class 随机链表的复制 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = cur.random == null ? null : map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
