package leetcode.lcsaf.差分数组;

public class 使数组中的所有元素都等于零 {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        diff[n] = -nums[n - 1];

        for (int i = 0; i < n + 1 - k; i++) {
            if (diff[i] < 0) {
                return false;
            }
            diff[i + k] += diff[i];
        }
        for (int i = n + 1 - k; i < n + 1; i++) {
            if (diff[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
