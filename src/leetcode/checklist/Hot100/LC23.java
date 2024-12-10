package leetcode.checklist.Hot100;

import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode head = new ListNode();
        head.next = null;
        ListNode pre = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            node.next = null;
            pre.next = node;
            pre = pre.next;
        }
        return head.next;
    }
}
