package leetcode.滑动窗口.定长滑动窗口;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class 找到一个数字的K美丽值 {

    public int divisorSubstrings(int num, int k) {
        int[] arr = numToArray(num);
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int temp = arr[i];
            for (int j = 1; j < k; j++) {
                temp = temp * 10 + arr[i + j];
            }
            if (temp != 0 && num % temp == 0) {
                ans++;
            }
        }
        return ans;
    }

    private int[] numToArray(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = charArray[i] - 48;
        }
        return arr;
    }
}
