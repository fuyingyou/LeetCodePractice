package leetcode.bank;

import java.util.ArrayDeque;
import java.util.List;

public class 美丽塔2 {

    /**
     * 前后缀分解
     * @param maxHeights
     * @return
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] arr = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        long[] suf = new long[n + 1];
        var deque = new ArrayDeque<Integer>();
        deque.push(n); // 哨兵
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];
            while (deque.size() > 1 && x <= arr[deque.peek()]) {
                int j = deque.pop();
                sum -= (long) arr[j] * (deque.peek() - j); // 撤销之前加到 sum 中的
            }
            sum += (long) x * (deque.peek() - i); // 从 i 到 deque.peek()-1 都是 x
            suf[i] = sum;
            deque.push(i);
        }

        long ans = sum;
        deque.clear();
        deque.push(-1); // 哨兵
        long pre = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            while (deque.size() > 1 && x <= arr[deque.peek()]) {
                int j = deque.pop();
                pre -= (long) arr[j] * (j - deque.peek()); // 撤销之前加到 pre 中的
            }
            pre += (long) x * (i - deque.peek()); // 从 deque.peek()+1 到 i 都是 x
            ans = Math.max(ans, pre + suf[i + 1]);
            deque.push(i);
        }
        return ans;
    }
}
