package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_longest_or_largest;

import java.util.Deque;
import java.util.LinkedList;

public class LC1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> queMax = new LinkedList<>();
        Deque<Integer> queMin = new LinkedList<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.add(nums[right]);
            queMin.add(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
