package leetcode.二分.最小化最大值;

public class 分配给商店的最多商品的最小值 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0, right = (int) (1e5 + 1);
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid, quantities, n)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int mid, int[] quantities, int n) {
        int cnt = 0;
        for (int x : quantities) {
            cnt += (int) Math.ceil((double) x / mid);
        }
        return cnt <= n;
    }

}
