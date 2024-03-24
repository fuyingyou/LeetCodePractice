package leetcode.dp;

import java.util.Arrays;

public class 找到最大开销的子字符串 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] dic = new int[26];
        char[] charArray = chars.toCharArray();
        int n = chars.length();
        Arrays.fill(dic, -2000);
        for (int i = 0; i < n; i++) {
            dic[charArray[i] - 97] = vals[i];
        }
        int len = s.length();
        char[] array = s.toCharArray();
        int cur = 0;
        int mx = 0;
        for (int i = 0; i < len; i++) {
            int temp = dic[array[i] - 97] == -2000 ? array[i] - 96 : dic[array[i] - 97];
            cur = Math.max(cur + temp, temp);
            mx = Math.max(cur, mx);
        }
        return mx;
    }
}
