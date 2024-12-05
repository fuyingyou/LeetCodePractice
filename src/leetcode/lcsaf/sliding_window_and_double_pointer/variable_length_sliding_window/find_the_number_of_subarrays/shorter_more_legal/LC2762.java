package leetcode.lcsaf.sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.shorter_more_legal;

import java.util.TreeMap;

public class LC2762 {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 。nums 的一个子数组如果满足以下条件，那么它是 不间断 的：
     * i，i + 1 ，...，j  表示子数组中的下标。对于所有满足 i <= i1, i2 <= j 的下标对，都有 0 <= |nums[i1] - nums[i2]| <= 2 。
     * 请你返回 不间断 子数组的总数目。
     * 子数组是一个数组中一段连续 非空 的元素序列。
     * 1 <= nums.length <= 10e5
     * 1 <= nums[i] <= 10e9
     */
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int left = 0, right = 0; right < n; right++) {
            treeMap.merge(nums[right], 1, Integer::sum);

            // treeMap中Key默认排序方式为从小到大
            while (treeMap.lastKey() - treeMap.firstKey() > 2) {
                int num = nums[left++];
                if (treeMap.get(num) == 1) {
                    treeMap.remove(num);
                } else {
                    treeMap.merge(num, -1, Integer::sum);
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
