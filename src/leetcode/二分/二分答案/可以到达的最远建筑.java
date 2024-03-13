package leetcode.二分.二分答案;

import java.util.PriorityQueue;

public class 可以到达的最远建筑 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int left = 0, right = heights.length;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(heights, mid, bricks, ladders)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] heights, int mid, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= mid; i++) {
            int x = heights[i] - heights[i - 1];
            if (x > 0) {
                if (priorityQueue.size() < ladders) {
                    priorityQueue.add(x);
                } else if (!priorityQueue.isEmpty() && priorityQueue.peek() < x) {
                    bricks -= priorityQueue.peek();
                    priorityQueue.poll();
                    priorityQueue.add(x);
                } else {
                    bricks -= x;
                }
                if (bricks < 0) {
                    return false;
                }
             }
        }
        return true;
    }


}
