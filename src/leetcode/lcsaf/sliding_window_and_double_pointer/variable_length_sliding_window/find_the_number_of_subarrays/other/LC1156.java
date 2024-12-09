package leetcode.lcsaf.sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.other;

public class LC1156 {
    /**
     * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
     * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
     * 1 <= text.length <= 20000
     * text 仅由小写英文字母组成。
     */
    public int maxRepOpt1(String text) {
        char[] charArray = text.toCharArray();
        int n = charArray.length;
        int[] dic = new int[26];
        for (char c : charArray) {
            dic[c - 'a']++;
        }
        int ans = 0;
        for (int left = 0; left < n; ) {
            int right = left;
            while (right < n && charArray[right] == charArray[left]) {
                right++;
            }
            int cnt1 = right - left;
            int idx = right + 1;
            while (idx < n && charArray[idx] == charArray[left]) {
                idx++;
            }
            int cnt2 = idx - right - 1;
            ans = Math.max(ans, Math.min(cnt1 + cnt2 + 1, dic[charArray[left] - 'a']));
            left = right;
        }
        return ans;
    }
}
