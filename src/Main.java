import java.util.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5};
//        int[] ans = answer(arr);
//        for (int x : ans) {
//            System.out.print(x + " ");
//        }
        int[] arr = answer2(69);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] answer(int[] x) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = x.length;
        int temp = 0;
        if (n <= 5) {
            temp = 6;
        }
        for (int i = 0; i < Math.min(11, n); i++) {
            deque.addLast(x[i]);
        }
        for (int i = 0; i < 5; i++) {
            deque.pollLast();
        }
        int size = deque.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = deque.pollLast();
        }
        if (n > 5) {
            temp = Arrays.stream(arr).sum();
        }
        temp = Math.min(temp, 100000);
        temp = Math.abs(temp);
        Deque<Integer> d = new ArrayDeque();
        while (temp > 0) {
            int a = temp % 9;
            d.addFirst(a);
            temp /= 9;
        }
        int len = d.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = d.pollFirst();
        }
        return ans;
    }


    public static int[] answer2(int x) {
        Deque<Integer> deque = new ArrayDeque<>();
        x = Math.min(x, 100000);
        x = Math.abs(x);
        while (x > 0) {
            int temp = x % 7;
            deque.addFirst(temp);
            x /= 7;
        }
        int n = deque.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = deque.pollFirst();
        }
        int ans = 0;
        if (arr.length >= 2) {
            ans = maxProfit(arr, 3);
        }
        ans = Math.abs(ans);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= ans; i++) {
            if (ans % i == 0) {
                list.add(i);
            }
        }
        int size = list.size();
        if (size <= 3) {
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = list.get(i);
            }
            return res;
        } else {
            int[] res = new int[3];
            for (int i = 1; i <= 3; i++) {
                res[i] = list.get(size - i);
            }
            return res;
        }
    }
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
