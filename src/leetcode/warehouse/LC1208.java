package leetcode.warehouse;

public class LC1208 {
    /**
     * 给你两个长度相同的字符串，s 和 t。
     *
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     *
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     *
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     *
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int left = 0, right = 0;
        int sum = 0, ans = 0;
        while (right < n) {
            sum += Math.abs(sCharArray[right] - tCharArray[right]);
            while (sum > maxCost) {
                sum -= Math.abs(sCharArray[left] - tCharArray[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
