package leetcode.lcsaf.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RangeFreqQuery {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
    }
    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) {
            return 0;
        }
        List<Integer> list = map.get(value);
        return binary_search(list, right + 1) - binary_search(list, left);
    }
    private int binary_search(List<Integer> list, int value) {
        int left = -1, right = list.size();
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) >= value) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
public class Test2080 {
}
