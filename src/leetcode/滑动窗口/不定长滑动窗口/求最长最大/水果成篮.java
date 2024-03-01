package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.HashMap;

public class 水果成篮 {
    /**
     * 内容只有两种的不定长窗口的最大长度
     * @param fruits
     * @return
     */
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        var map = new HashMap<Integer, Integer>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                int temp = map.get(fruits[left]);
                if (temp > 1) {
                    map.put(fruits[left], temp - 1);
                } else {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,2,2,2};
        System.out.println(totalFruit(arr));
    }
}
