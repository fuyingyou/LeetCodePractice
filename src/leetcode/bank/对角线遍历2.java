package leetcode.bank;

import java.util.*;

public class 对角线遍历2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        var map = new LinkedHashMap<Integer, List<Integer>>();
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            var array = nums.get(i).stream().mapToInt(Integer::intValue).toArray();
            int len = array.length;
            sum += len;
            for (int j = 0; j < len; j++) {
                if (map.containsKey(i + j)) {
                    map.get(i + j).add(array[j]);
                } else {
                    var list = new ArrayList<Integer>();
                    list.add(array[j]);
                    map.put(i + j, list);
                }
            }
        }
        var ans = new int[sum];
        int idx = 0;
        for (int key : map.keySet()) {
            var tempList = map.get(key);
            int len = tempList.size();
            for (int i = len - 1; i >= 0; i--) {
                ans[idx++] = tempList.get(i);
            }
        }
        return ans;
    }
}
