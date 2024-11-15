package leetcode.bank;

import java.util.*;

public class 统计好节点的数目 {
    /**
     * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
     * 如果一个节点的所有子节点为根的
     * 子树
     *  包含的节点数相同，则认为该节点是一个 好节点。
     * 返回给定树中 好节点 的数量。
     * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
     */

    private int ans;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] arr = new ArrayList[n];
        Arrays.setAll(arr, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            arr[node1].add(node2);
            arr[node2].add(node1);
        }
        dfs(0, -1, arr);
        return ans;
    }

    private int dfs(int cur, int fa, List<Integer>[] arr) {
        int size = 1;
        int first_son = 0;
        boolean isBalance = true;
        for (int y : arr[cur]) {
            if (y == fa) {
                continue;
            }
            int son_size = dfs(y, cur, arr);
            if (first_son == 0) {
                first_son = son_size;
            } else if (first_son != son_size) {
                isBalance = false;
            }
            size += son_size;
        }
        ans += isBalance ? 1 : 0;
        return size;
    }
}
