package leetcode.warehouse;

public class LC3325 {
    /**
     * 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
     * 子字符串 是字符串中的一个连续、 非空 的字符序列。
     * 1 <= s.length <= 3000
     * 1 <= k <= s.length
     * s 仅由小写英文字母组成。
     */
    public int numberOfSubstrings(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] dic = new int[26];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            dic[charArray[right] - 'a']++;
            while (dic[charArray[right] - 'a'] == k) {
                ans += n - right;
                dic[charArray[left] - 'a']--;
                left++;
            }
        }
        return ans;
    }
}
