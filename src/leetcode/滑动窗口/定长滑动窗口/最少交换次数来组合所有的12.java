package leetcode.滑动窗口.定长滑动窗口;

public class 最少交换次数来组合所有的12 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                cnt++;
            }
        }
        int mx = 0;
        int temp = 0;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == 1) {
                temp++;
            }
        }
        mx = Math.max(mx, temp);
        for (int i = cnt; i < n + cnt - 1; i++) {
            if (nums[i - cnt] == 1) {
                temp--;
            }
            if (nums[i % n] == 1) {
                temp++;
            }
            mx = Math.max(mx, temp);
        }
        return cnt - mx;
    }
}
