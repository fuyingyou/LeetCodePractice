package leetcode.lcsaf.binary_search;

import java.util.PriorityQueue;

public class 移山所需的最少秒数 {
    /**
     * 给你一个整数 mountainHeight 表示山的高度。
     *
     * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
     *
     * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
     *
     * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
     * 山的高度降低 1，需要 workerTimes[i] 秒。
     * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
     * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
     */

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        return binary_search(mountainHeight, workerTimes);
    }

    private long binary_search(int mountainHeight, int[] workerTimes) {
        long left = -1, right = Long.MAX_VALUE / 3;
        while (left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if (f(workerTimes, mid, mountainHeight)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean f(int[] workerTimes, long mid, int mountainHeight) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int x : workerTimes) {
            pq.add(new int[]{x, x});
        }
        long sum = 0;
        while (mountainHeight-- > 0) {
            int[] poll = pq.poll();
            sum += poll[0];
            poll[0] += poll[1];
            pq.add(poll);
        }

        return sum <= mid;
    }
}
