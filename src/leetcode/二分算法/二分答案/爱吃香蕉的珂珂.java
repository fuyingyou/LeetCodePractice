package leetcode.二分算法.二分答案;

public class 爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check (piles, mid, h)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] piles, int mid, int h) {
        int cnt = 0;
        for (int x : piles) {
            cnt += (int) Math.ceil((double) x / mid);
        }
        return cnt <= h;
    }
}
