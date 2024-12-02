package leetcode.lcsaf.binary_search.二分答案;

public class 在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(weights, mid, days)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] weights, int mid, int days) {
        int cnt = 0;
        int cur = 0;
        for (int x : weights) {
            if (x > mid) {
                return false;
            } else if (cur + x > mid) {
                cur = x;
                cnt++;
            } else {
                cur += x;
            }
        }
        if (cur > 0 ) {
            cnt++;
        }
        return cnt <= days;
    }

}
