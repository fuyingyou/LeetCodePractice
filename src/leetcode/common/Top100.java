package leetcode.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Top100 {

    // 1. 两数之加
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    // 2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        pre.next = null;
        ListNode cur = pre;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + temp;
            temp = sum / 10;
            int x = sum % 10;
            cur.next = new ListNode(x);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp == 1) {
            cur.next = new ListNode(temp);
        }
        return pre.next;
    }

    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        var set = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        for (char ch : chars) {
            while (set.contains(ch)) {
                set.remove(chars[left++]);
            }
            set.add(ch);
            res = Math.max(res, set.size());
        }
        return res;
    }

    // 4. 寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n + m == 1) {
            if (n == 0) {
                return nums2[0];
            } else {
                return nums1[0];
            }
        }
        if (n + m == 2) {
            if (n == 0) {
                return (nums2[0] + nums2[1]) / 2;
            } else if (m == 0) {
                return (nums1[0] + nums1[1]) / 2;
            } else {
                return (nums2[0] + nums2[0]) / 2;
            }
        }

        return 0;
    }
}
