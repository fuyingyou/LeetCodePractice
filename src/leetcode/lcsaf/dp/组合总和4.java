package leetcode.lcsaf.dp;

import java.util.Arrays;

public class 组合总和4 {
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n && nums[j] <= i; j++) {
                f[i] += f[i - nums[j]];
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(combinationSum4(arr, 4));
    }
    private int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                break;
            }
            ans += dfs(nums, target - nums[i]);
        }
        return ans;
    }
}
