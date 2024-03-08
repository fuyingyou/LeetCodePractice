package leetcode.二分算法.二分答案;

import java.util.Arrays;

public class 准时到达的列车最小时速 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) return -1;
        int left = 0, right = (int) (1e7 + 1);
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(dist, mid) <= hour) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private double check(int[] dist, int mid) {
        double cnt = 0;
        for (int x : dist) {
            cnt = Math.ceil(cnt);
            cnt += (double) x / mid;
        }
        return cnt;
    }

}
