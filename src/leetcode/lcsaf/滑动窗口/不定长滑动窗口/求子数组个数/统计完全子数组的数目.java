package leetcode.lcsaf.滑动窗口.不定长滑动窗口.求子数组个数;

import java.util.HashMap;
import java.util.Map;

public class 统计完全子数组的数目 {
    /**
     * 给你一个由 正 整数组成的数组 nums 。
     * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
     * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
     * 返回数组中 完全子数组 的数目。
     * 子数组 是数组中的一个连续非空序列。
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 2000
     */
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        int size = map.size();
        int cnt = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.get(nums[right]) + 1);
            if (map.get(nums[right]) == 1) {
                cnt++;
                while (cnt == size) {
                    ans += n - right;
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        cnt--;
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
