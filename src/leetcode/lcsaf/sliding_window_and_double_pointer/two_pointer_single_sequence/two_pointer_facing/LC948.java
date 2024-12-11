package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_single_sequence.two_pointer_facing;

import java.util.Arrays;

public class LC948 {
    /**
     * 你的初始 能量 为 power，初始 分数 为 0，只有一包令牌以整数数组 tokens 给出。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
     *
     * 你的目标是通过有策略地使用这些令牌以 最大化 总 分数。在一次行动中，你可以用两种方式中的一种来使用一个 未被使用的 令牌（但不是对同一个令牌使用两种方式）：
     *
     * 朝上：如果你当前 至少 有 tokens[i] 点 能量 ，可以使用令牌 i ，失去 tokens[i] 点 能量 ，并得到 1 分 。
     * 朝下：如果你当前至少有 1 分 ，可以使用令牌 i ，获得 tokens[i] 点 能量 ，并失去 1 分 。
     * 在使用 任意 数量的令牌后，返回我们可以得到的最大 分数 。
     * 0 <= tokens.length <= 1000
     * 0 <= tokens[i], power < 10e4
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int left = 0, right = n - 1;
        int ans = 0;
        int sum = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                sum++;
                ans = Math.max(ans, sum);
            } else if (sum > 0){
                power += tokens[right--];
                sum--;
            } else {
                break;
            }
        }
        return ans;
    }
}
