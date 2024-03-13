package leetcode.二分.二分答案;

import java.util.Arrays;

public class 完成旅途的最少时间 {
    public long minimumTime(int[] time, int totalTrips) {
        int i = Arrays.stream(time).min().getAsInt();
        long left = 0, right = (long) i * totalTrips + 1;
        while (left + 1 < right) {
            long mid = (right - left)/2 + left;
            if (check(mid, time) >= totalTrips) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
    private long check(long mid, int[] time) {
        long cnt = 0;
        for (int num : time) {
            cnt += mid / num;
        }
        return cnt;
    }

}
