package leetcode.差分数组;

public class 拼车 {
    public boolean carPooling(int[][] trips, int capacity) {

        var arr = new int[1001];
        for (int[] x : trips) {
            arr[x[1]] += x[0];
            arr[x[2]] -= x[0];
        }
        for (int i = 1; i < 1001; i++) {
            arr[i] += arr[i-1];
        }
        for (int i = 0; i < 1001; i++) {
            if (arr[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
