package leetcode.checklist.Hot100;

import java.util.*;

public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : prerequisites) {
            degree[arr[0]]++;
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                map.put(arr[1], list);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int x = deque.pollFirst();
            if (!map.containsKey(x)) {
                continue;
            }
            List<Integer> list = map.get(x);
            for (int num : list) {
                degree[num]--;
                if (degree[num] == 0) {
                    deque.add(num);
                }
            }
        }
        for (int i : degree) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
