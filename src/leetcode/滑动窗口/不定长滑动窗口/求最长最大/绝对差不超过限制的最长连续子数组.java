package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.Deque;
import java.util.LinkedList;

public class 绝对差不超过限制的最长连续子数组 {
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
