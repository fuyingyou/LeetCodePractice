import java.util.*;
import java.lang.Math;

public class Main {
//    public static void main(String[] args) {
////        int[] arr = new int[]{1,2,3,4,5};
////        int[] ans = answer(arr);
////        for (int x : ans) {
////            System.out.print(x + " ");
////        }
//        int[] arr = answer2(69);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//    }
//
//    public static int[] answer(int[] x) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        int n = x.length;
//        int temp = 0;
//        if (n <= 5) {
//            temp = 6;
//        }
//        for (int i = 0; i < Math.min(11, n); i++) {
//            deque.addLast(x[i]);
//        }
//        for (int i = 0; i < 5; i++) {
//            deque.pollLast();
//        }
//        int size = deque.size();
//        int[] arr = new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = deque.pollLast();
//        }
//        if (n > 5) {
//            temp = Arrays.stream(arr).sum();
//        }
//        temp = Math.min(temp, 100000);
//        temp = Math.abs(temp);
//        Deque<Integer> d = new ArrayDeque();
//        while (temp > 0) {
//            int a = temp % 9;
//            d.addFirst(a);
//            temp /= 9;
//        }
//        int len = d.size();
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            ans[i] = d.pollFirst();
//        }
//        return ans;
//    }
//
//
//    public static int[] answer2(int x) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        x = Math.min(x, 100000);
//        x = Math.abs(x);
//        while (x > 0) {
//            int temp = x % 7;
//            deque.addFirst(temp);
//            x /= 7;
//        }
//        int n = deque.size();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = deque.pollFirst();
//        }
//        int ans = 0;
//        if (arr.length >= 2) {
//            ans = maxProfit(arr, 3);
//        }
//        ans = Math.abs(ans);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= ans; i++) {
//            if (ans % i == 0) {
//                list.add(i);
//            }
//        }
//        int size = list.size();
//        if (size <= 3) {
//            int[] res = new int[size];
//            for (int i = 0; i < size; i++) {
//                res[i] = list.get(i);
//            }
//            return res;
//        } else {
//            int[] res = new int[3];
//            for (int i = 1; i <= 3; i++) {
//                res[i] = list.get(size - i);
//            }
//            return res;
//        }
//    }
//    public static int maxProfit(int[] prices, int fee) {
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//        }
//        return dp[n - 1][0];
//    }

    public static void main(String[] args) {

        int[] answer = answer(69);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] answer(int x) {
        int[] step1Res = step1(x);
        int step2Res = step2(step1Res);
        return step3(step2Res);
    }

    public static int[] step1(int n) {
        if (n > 100000) {
            n = 100000;
        }
        n = Math.abs(n);
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            stringBuilder.insert(0, n % 7);
            n /= 7;
        }
        int[] res = new int[stringBuilder.length()];
        for (int i = 0; i < stringBuilder.length(); i++) {
            res[i] = stringBuilder.charAt(i) - '0';
        }
        return res;
    }

    public static int step2(int[] x) {
        if (x.length < 2) {
            return 0;
        }
        //买
        int buy = -x[0];
        //卖
        int sell = 0;
        for (int i = 1; i < x.length; i++) {
            sell = Math.max(buy + x[i] - 3, sell);
            buy = Math.max(buy, sell - x[i]);
        }
        return sell;
    }

    public static int[] step3(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
            }
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (res.size() > 3) {
            return new int[]{res.get(0), res.get(1), res.get(2)};
        } else {
            if (res.size() == 2) {
                return new int[]{res.get(1), res.get(0)};
            } else {
                return new int[]{res.get(2), res.get(1), res.get(0)};
            }
        }
    }
}
