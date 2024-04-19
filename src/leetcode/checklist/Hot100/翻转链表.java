package leetcode.checklist.Hot100;

import leetcode.common.ListNode;

import java.util.List;

public class 翻转链表 {
    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 反转链表2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    //
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        int cnt = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cnt++;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        while (cnt >= k) {
            cnt -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            p0.next.next = cur;
            ListNode next = p0.next;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }
}
