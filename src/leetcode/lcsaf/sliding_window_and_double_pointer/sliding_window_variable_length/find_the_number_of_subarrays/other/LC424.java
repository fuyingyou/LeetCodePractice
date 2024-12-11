package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_number_of_subarrays.other;

public class LC424 {
    /**
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
     * 1 <= s.length <= 10e5
     * s 仅由大写英文字母组成
     * 0 <= k <= s.length
     */

    public int characterReplacement(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] dic = new int[26];
        int left = 0;
        int historyMax = 0;
        // 使用窗口记录出现过的最大值
        for (int right = 0; right < n; right++) {
            dic[charArray[right] - 'A']++;
            historyMax = Math.max(historyMax, dic[charArray[right] - 'A']);
            if (right - left + 1 > historyMax + k) {
                dic[charArray[left++] - 'A']--;
            }
        }
        return n - left;
    }
}
