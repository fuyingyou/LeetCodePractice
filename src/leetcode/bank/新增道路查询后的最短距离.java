package leetcode.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 新增道路查询后的最短距离 {
    /**
     * 给你一个整数 n 和一个二维整数数组 queries。
     *
     * 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
     *
     * queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
     *
     * 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
     *
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] f = new int[n];
        List<Integer>[] from = new List[n];
        Arrays.setAll(from, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            from[r].add(l);
            if (f[l] + 1 < f[r]) {
                 f[r] = f[l] + 1;
                 for (int j = r + 1; j < n; j++) {
                     f[j] = Math.min(f[j], f[j - 1] + 1);
                     for (int x : from[j]) {
                         f[j] = Math.min(f[j], f[x] + 1);
                     }
                 }
            }
            ans[i] = f[n - 1];
        }
        return ans;
    }
}
