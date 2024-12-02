package leetcode.lcsaf.dp;

import java.util.Arrays;

public class 统计打字方案数 {
    private final static int MOD = (int) (1e9 + 7);
    private int[] memo;
    public int countTexts(String pressedKeys) {
        char[] charArray = pressedKeys.toCharArray();
        int n = charArray.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(charArray, n - 1);
    }

    private int dfs(char[] charArray, int idx) {
        if (idx < 1) {
            return 1;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int mx = 0;
        if (charArray[idx] == '7' || charArray[idx] == '9') {
            mx = 4;
        } else {
            mx = 3;
        }
        long ans = 0;
        int left;
        for (left = idx - 1; left >= 0; left--) {
            ans += dfs(charArray, left);
            if (charArray[left] != charArray[idx] || idx - left + 1 > mx) {
                break;
            }
        }
        if (left < 0 && idx < mx) {
            ans += 1;
        }
        ans %= MOD;
        memo[idx] = (int) ans;
        return memo[idx];
    }
}
