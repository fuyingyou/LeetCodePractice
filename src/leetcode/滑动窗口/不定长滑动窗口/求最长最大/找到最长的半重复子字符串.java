package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

public class 找到最长的半重复子字符串 {
    /**
     * 需要记录相邻的位置
     * 一直前进，直到遇到相邻字符是重复的，查看如果已经有重复的，就右移left,直至删去前一个相邻，然后加上当前字符
     * @param s
     * @return
     */
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        int idx = -1;
        int left = 0;
        int n = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (charArray[i] == charArray[i - 1]) {
                if (idx >= 0) {
                    left = idx + 1;
                }
                idx = i - 1;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
