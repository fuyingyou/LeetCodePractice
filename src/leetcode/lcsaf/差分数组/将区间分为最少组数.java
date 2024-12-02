package leetcode.lcsaf.差分数组;

public class 将区间分为最少组数 {
    public int minGroups(int[][] intervals) {
        int num = 0;
        for (int[] arr : intervals) {
            num = Math.max(num, arr[1]);
        }
        int[] chafen = new int[num + 1];
        for (int[] arr : intervals) {
            chafen[arr[0] - 1] += 1;
            chafen[arr[1]] -= 1;
        }
        for (int i = 1; i < num + 1; i++) {
            chafen[i] += chafen[i - 1];
        }
        int res = 0;
        for (int i = 0; i < num + 1; i++) {
            res = Math.max(res, chafen[i]);
        }
        return res;
    }
}
