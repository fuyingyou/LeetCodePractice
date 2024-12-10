package leetcode.lcsaf.sliding_window_and_double_pointer.single_sequence_two_pointers.double_pointer_facing;

import java.util.Arrays;

public class LCP28 {
    /**
     * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
     *
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     * 2 <= nums.length <= 10^5
     * 1 <= nums[i], target <= 10^5
     */

    public static final int MOD = (int) (1e9 + 7);
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                ans += right - left;
                ans %= MOD;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
