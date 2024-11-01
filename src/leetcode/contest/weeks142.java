package leetcode.contest;

import java.util.*;

public class weeks142 {
    public int possibleStringCount(String word) {
        char[] charArray = word.toCharArray();
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                cnt++;
            } else {
                sum += cnt;
                cnt = 0;
            }
        }
        return cnt + sum;
    }

    // todo 超时 尝试前缀和之类方法优化

    public int possibleStringCount(String word, int k) {
        int mod = (int) (1e9 + 7);
        int n = word.length();
        if (n == k) {
            return 1;
        }

        List<Integer> list = new ArrayList<>();
        char[] charArray = word.toCharArray();
        int cnt = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 0;
            }
        }

        if (cnt > 0) {
            list.add(cnt);
        }

        int[] dp = new int[n - k + 1];
        dp[0] = 1;
        // 第i个堆
        for (int i = 0; i < list.size(); i++) {
            // 共取j个数
            for (int j = 0; j < n - k + 1; j++) {
                // 当前堆取得数目
                for (int m = Math.min(list.get(i), j); m >= 0; m--) {
                    dp[j] += dp[j - m];
                    dp[j] %= mod;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n - k + 1; i++) {
            res += dp[i];
            res %= mod;
        }

        return res;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        char[] charArray = s.toCharArray();
        int[] copy = Arrays.copyOf(parent, parent.length);
        for (int i = 1; i < parent.length; i++) {
            int x = parent[i];
            while (x >= 0 && charArray[x] != charArray[i]) {
                x = parent[x];
            }
            if (x >= 0) {
                copy[i] = x;
            }
        }
        int[] res = new int[parent.length];
        Arrays.fill(res, 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            map.put(copy[i], map.getOrDefault(copy[i], 0) + 1);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < parent.length; i++) {
            if (!map.containsKey(i)) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int pollParent = copy[poll];
            if (pollParent < 0) {
                break;
            }
            res[pollParent] += res[poll];
            map.put(pollParent, map.get(pollParent) - 1);
            if (map.get(pollParent) == 0) {
                deque.add(pollParent);
            }
        }
        return res;
    }

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        // 第i天，在第j个城市，0停留 1过来
        int[][][] dp = new int[k + 1][n][2];
        for (int i = 0; i < n; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = 0;
        }
        // 天
        for (int i = 0; i < k; i++) {
            // 城市
            for (int j = 0; j < n; j++) {
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1]) + stayScore[i][j];
                for (int m = 0; m < n; m++) {
                    dp[i + 1][j][1] = Math.max(dp[i + 1][j][1], Math.max(dp[i][m][0], dp[i][m][1]) + travelScore[m][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(dp[k][i][0], dp[k][i][1]));
        }
        return res;
    }
}
