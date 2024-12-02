package leetcode.warehouse;

import java.util.HashMap;

public class 最大字符串配对数目 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        var map = new HashMap<String, Integer>();

        for (String word : words) {
            if (map.containsKey(word)) {
                int temp = map.get(word);
                ans += temp;
                map.put(word, temp + 1);
            } else {
                map.put(reverseStr(word), 1);
            }
        }

        return ans;
    }

    private String reverseStr(String str) {
        char[] charArray = str.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < n / 2; i++) {
            char ch = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1- i] = ch;
        }

        return String.valueOf(charArray);
    }
}
