package leetcode.lcsaf.diff_array;

import java.util.Arrays;

public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        var chafen = new int[n + 1];
        for (int[] arr : bookings) {
            chafen[arr[0]] += arr[2];
            chafen[arr[1] + 1] -= arr[2];
        }
        for (int i = 1; i < n + 1; i++) {
            chafen[i] += chafen[i-1];
        }
        return Arrays.copyOfRange(chafen, 1, n + 1);
    }
}
