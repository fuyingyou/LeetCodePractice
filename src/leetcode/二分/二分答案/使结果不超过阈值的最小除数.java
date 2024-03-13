package leetcode.二分.二分答案;

public class 使结果不超过阈值的最小除数 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0, right = (int) (1e6 + 1);
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                cnt += (int) Math.ceil((double) num / mid);
            }
            if (cnt <= threshold) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
