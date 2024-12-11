package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_single_sequence.two_pointer_facing;

public class LC125 {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * 1 <= s.length <= 2 * 10e5
     * s 仅由可打印的 ASCII 字符组成
     */

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char lc = charArray[left];
            while (left <= right) {
                lc = charArray[left];
                if (lc >= 'A' && lc <= 'Z') {
                    lc = (char) (lc - 'A' + 'a');
                } else if (lc >= 'a' && lc <= 'z' || lc >= '0' && lc <= '9') {
                    break;
                }
                left++;
            }
            char rc = charArray[right];
            while (left <= right) {
                rc = charArray[right];
                if (rc >= 'A' && rc <= 'Z') {
                    rc = (char) (rc - 'A' + 'a');
                } else if (rc >= 'a' && rc <= 'z' || rc >= '0' && rc <= '9') {
                    break;
                }
                right--;
            }
            if (lc != rc) {
                return false;
            }
        }
        return true;
    }

}
