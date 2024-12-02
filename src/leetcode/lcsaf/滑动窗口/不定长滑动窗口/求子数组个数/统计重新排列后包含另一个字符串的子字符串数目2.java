package leetcode.lcsaf.滑动窗口.不定长滑动窗口.求子数组个数;

public class 统计重新排列后包含另一个字符串的子字符串数目2 {
    /**
     * 给你两个字符串 word1 和 word2 。
     *
     * 如果一个字符串 x 重新排列后，word2 是重排字符串的
     * 前缀
     *  ，那么我们称字符串 x 是 合法的 。
     *
     * 请你返回 word1 中 合法
     * 子字符串
     *  的数目。
     *
     * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
     * 1 <= word1.length <= 10e6
     * 1 <= word2.length <= 10e4
     * word1 和 word2 都只包含小写英文字母。
     */
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        int[] dic = new int[128];
        for (char c : word2CharArray) {
            dic[c]++;
        }
        long ans = 0;
        int cnt = 0;
        for (int x : dic) {
            if (x > 0) {
                cnt++;
            }
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            dic[word1CharArray[right]]--;
            if (dic[word1CharArray[right]] == 0) {
                cnt--;
            }
            while (cnt == 0) {
                ans += n - right;
                dic[word1CharArray[left]]++;
                if (dic[word1CharArray[left]] > 0) {
                    cnt++;
                }
                left++;
            }
        }
        return ans;
    }
}
