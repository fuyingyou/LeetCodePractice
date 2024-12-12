package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_one_sequence.two_pointer_facing;

public class LC1616 {
    /**
     * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
     * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
     * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
     * 注意， x + y 表示连接字符串 x 和 y 。
     * 1 <= a.length, b.length <= 105
     * a.length == b.length
     * a 和 b 都只包含小写英文字母
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return isHuiWen(a, i, j) || isHuiWen(b, i, j);
    }

    private boolean isHuiWen(String a, int i, int j) {
        while (i < j && a.charAt(i) == a.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
