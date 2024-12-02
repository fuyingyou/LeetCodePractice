package leetcode.warehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2831 {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
     * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
     * 子数组 是数组中一个连续且可能为空的元素序列。
     */
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        List<Integer>[] lists = new List[n + 1];
        Arrays.setAll(lists, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            lists[nums.get(i)].add(i);
        }

        for (List<Integer> list : lists) {
            int left = 0, right = 0;
            for (; right < list.size(); right++) {
                while ((list.get(right) - list.get(left) + 1) - (right - left + 1) > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}
