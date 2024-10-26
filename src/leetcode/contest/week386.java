package leetcode.contest;

//import com.sun.tools.javac.Main;

import java.util.*;

public class week386 {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x) && map.get(x) >= 2) {
                return false;
            } else {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        return true;
    }

//    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
//        long res = 0;
//        int n = bottomLeft.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (bottomLeft[i][0] <= bottomLeft[j][0] && bottomLeft[i][1] <= bottomLeft[j][1] && topRight[i][0] > bottomLeft[j][0] && topRight[i][1] > bottomLeft[j][1]) {
//                    int x = Math.min(topRight[j][0], topRight[i][0]);
//                    int y = Math.min(topRight[j][1], topRight[i][1]);
//                    int d = Math.min(x - bottomLeft[j][0], y - bottomLeft[j][1]);
//                    res = Math.max(res, (long) d * d);
//                } else if (bottomLeft[i][0] <= bottomLeft[j][0] && bottomLeft[i][1] >= bottomLeft[j][1] && topRight[i][0] > bottomLeft[j][0]) {
//                    int x = Math.min(topRight[j][0], topRight[i][0]);
//                    int y = Math.min(topRight[j][1], topRight[i][1]);
//                    int d = Math.min(x - bottomLeft[j][0], y - bottomLeft[i][1]);
//                    d = Math.max(0, d);
//                    res = Math.max(res, (long) d * d);
//                }
//            }
//        }
//        return res;
//    }
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long res = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mxBottom = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int mxLeft = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int minTop = Math.max(topRight[i][0], topRight[j][0]);
                int minRight = Math.max(topRight[i][1], topRight[j][1]);
                if (mxBottom < minTop &&  mxLeft < minRight) {
                    int d = Math.min(minRight - mxLeft, minTop - mxBottom);
                    res = Math.max(res, (long) d * d);
                }
            }
        }
        return res;
    }
    //标记所有下标的最早秒数 I
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length, m = changeIndices.length;
        if (n > m) {
            return -1;
        }
        int[] lastIdx = new int[n];
        int left = n - 1, right = m + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(lastIdx, mid, changeIndices, nums)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right > m ? -1 : right;
    }

    private boolean check(int[] lastIdx, int mid, int[] changeIndices, int[] nums) {
        Arrays.fill(lastIdx, -1);
        //记录最后考试的时间
        for (int i = 0; i < mid; i++) {
            lastIdx[changeIndices[i] - 1] = i;
        }
        //无法进行所有考试，直接扩大所需天数
        for (int x : lastIdx) {
            if (x < 0) {
               return false;
            }
        }
        //尝试进行所有考试
        int cnt = 0;
        for (int i = 0; i < mid; i++) {
            int idx = changeIndices[i] - 1;
            if (lastIdx[idx] == i) {
                if (cnt < nums[idx]) {
                    return false;
                } else {
                    cnt -= nums[idx];
                }
            } else {
                cnt++;
            }
        }
        return true;
    }
}
