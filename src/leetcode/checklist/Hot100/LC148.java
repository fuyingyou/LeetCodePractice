package leetcode.checklist.Hot100;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC148 {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        ListNode pre = new ListNode();
        pre.next = null;
        ListNode ans = pre;
        for (ListNode listNode : list) {
            listNode.next = null;
            pre.next = listNode;
            pre = pre.next;
        }
        return ans.next;
    }
}
