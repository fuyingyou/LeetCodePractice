package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class 设计相邻元素求和服务 {
    /**
     * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
     *
     * 实现 neighborSum 类：
     *
     * neighborSum(int [][]grid) 初始化对象。
     * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
     * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
     */

}
class NeighborSum {

    Map<Integer, int[]> map = new HashMap<>();
    int[][] arr;

    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    public NeighborSum(int[][] grid) {
        arr = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        if (map1.containsKey(value)) {
            return map1.get(value);
        }
        int[] idx = map.get(value);
        int sum = 0;
        if (idx[0] - 1 >= 0) {
            sum += arr[idx[0] - 1][idx[1]];
        }
        if (idx[0] + 1 < arr.length) {
            sum += arr[idx[0] + 1][idx[1]];
        }

        if (idx[1] - 1 >= 0) {
            sum += arr[idx[0]][idx[1] - 1];
        }
        if (idx[0] + 1 < arr[0].length) {
            sum += arr[idx[0]][idx[1] + 1];
        }
        map1.put(value, sum);
        return sum;
    }

    public int diagonalSum(int value) {
        if (map2.containsKey(value)) {
            return map2.get(value);
        }
        int[] idx = map.get(value);
        int sum = 0;
        if (idx[0] - 1 >= 0 && idx[1] - 1 >= 0) {
            sum += arr[idx[0] - 1][idx[1] - 1];
        }

        if (idx[0] - 1 >= 0 && idx[1] + 1 < arr[0].length) {
            sum += arr[idx[0] - 1][idx[1] + 1];
        }

        if (idx[0] + 1 < arr.length && idx[1] - 1 >= 0) {
            sum += arr[idx[0] + 1][idx[1] - 1];
        }

        if (idx[0] + 1 < arr.length && idx[1] + 1 < arr[0].length) {
            sum += arr[idx[0] + 1][idx[1] + 1];
        }
        map2.put(value, sum);
        return sum;
    }
}
