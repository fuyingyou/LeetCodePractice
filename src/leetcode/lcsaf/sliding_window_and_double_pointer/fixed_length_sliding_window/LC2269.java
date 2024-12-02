package leetcode.lcsaf.sliding_window_and_double_pointer.fixed_length_sliding_window;

public class LC2269 {

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
