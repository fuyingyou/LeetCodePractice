package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        int mx = 0;
        int[] dic = new int[10001];
        for (int x : nums) {
            dic[x]++;
            mx = Math.max(mx, x);
        }
        int[] f = new int[mx + 1];
        f[1] = dic[1];
        for (int i = 2; i <= mx; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + i * dic[i]);
        }
        return f[mx];
    }

    private int dfs(int[] dic, int idx) {
        if (idx == 0) {
            return 0;
        }
        if (idx == 1) {
            return dic[idx];
        }
        return Math.max(dfs(dic, idx - 1), dfs(dic, idx - 2) + idx * dic[idx]);
    }
}
