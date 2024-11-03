package leetcode.binary_search.二分答案;

import java.util.Arrays;

public class 制作m束花所需的最少天数 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }
        int left = 0, right = Arrays.stream(bloomDay).max().getAsInt() + 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] bloomDay, int mid, int m, int k) {
        int cnt = 0;
        int sum = 0;
        for (int x : bloomDay) {
            if (x <= mid) {
                cnt++;
            } else {
                sum += cnt / k;
                cnt = 0;
            }
        }
        sum += cnt / k;
        return sum >= m;
    }
}
