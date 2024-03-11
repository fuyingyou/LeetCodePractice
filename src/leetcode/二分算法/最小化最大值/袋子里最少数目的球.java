package leetcode.二分算法.最小化最大值;

public class 袋子里最少数目的球 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int mid, int maxOperations) {
        int cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / mid;
        }
        return cnt <= maxOperations;
    }
}
