package leetcode.binary_search.二分答案;

import java.util.Arrays;

public class 每个小孩最多能分到多少糖果 {
    public int maximumCandies(int[] candies, long k) {
        int i = Arrays.stream(candies).min().getAsInt();
        int left = 0, right = i + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid, candies) >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private long check(int mid, int[] candies) {
        long cnt = 0;
        for (int num : candies) {
            cnt += num / mid;
        }
        return cnt;
    }
}
