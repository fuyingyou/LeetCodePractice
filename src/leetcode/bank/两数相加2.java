package leetcode.bank;

import leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while (l1 != null) {
            deque1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.addLast(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode();
        head.next = null;
        int temp = 0;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int sum = deque1.pollLast() + deque2.pollLast() + temp;
            temp = sum / 10;
            insertHead(head, sum % 10);
        }
        while (!deque1.isEmpty()) {
            int sum = deque1.pollLast() + temp;
            temp = sum / 10;
            insertHead(head, sum % 10);
        }
        while (!deque2.isEmpty()) {
            int sum = deque2.pollLast() + temp;
            temp = sum / 10;
            insertHead(head, sum % 10);
        }
        if (temp != 0) {
            insertHead(head, temp);
        }
        return head.next;
    }
    private void insertHead(ListNode head, int val) {
        ListNode tempNode = new ListNode(val);
        tempNode.next = head.next;
        head.next = tempNode;
    }
}
