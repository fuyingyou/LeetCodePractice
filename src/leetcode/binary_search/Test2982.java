package leetcode.binary_search;

import java.util.*;

public class Test2982 {
    /**
     * 给你一个仅由小写英文字母组成的字符串 s 。
     *
     * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
     *
     * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
     *
     * 子字符串 是字符串中的一个连续 非空 字符序列。
     */
    public int maximumLength(String s) {
        List<Integer>[] dic = new ArrayList[26];
        Arrays.setAll(dic, i -> new ArrayList<>());
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i + 1 == n || charArray[i] != charArray[i + 1]) {
                dic[charArray[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }
        int ans = 0;
        for (List<Integer> list : dic) {
            if (list.isEmpty()) {
                continue;
            }
            list.sort(Collections.reverseOrder());
            list.add(0);
            list.add(0);
            ans = Math.max(ans, Math.max(list.get(0) - 2, Math.max(Math.min(list.get(0) - 1, list.get(1)), list.get(2))));
        }

        return ans > 0 ? ans : -1;
    }
}
