package leetcode.binary_search;

import java.util.Arrays;
import java.util.Comparator;

public class 供暖器 {
    public int findRadius(int[] houses, int[] heaters) {
        return binary_search(houses, heaters);
    }

    private int binary_search(int[] houses, int[] heaters) {
        int left = -1, right = houses.length + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int binary_search(int[] heaters, int x) {
        int left = -1, right = heaters.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (heaters[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] houses, int[] heaters, int mid) {
        for (int x : houses) {
            int idx = binary_search(heaters, x);
            if (idx < 0) {
                if (heaters[0] - x > mid) {
                    return false;
                }
            } else if (idx >= heaters.length - 1) {
                if (x - heaters[0] > mid) {
                    return false;
                }
            } else {
                if (x - heaters[idx] > mid && heaters[idx + 1] - x > mid)
                return false;
            }
        }
        return true;
    }
}
