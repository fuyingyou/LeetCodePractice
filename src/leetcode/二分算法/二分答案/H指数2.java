package leetcode.二分算法.二分答案;

public class H指数2 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    boolean check(int[] arr, int mid) {
        if (arr[arr.length - mid] >= mid) {
            return true;
        }
        return false;
    }

}
