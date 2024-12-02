package leetcode.warehouse;

public class LC567 {
    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     * 用字典记录字符串每个字符出现的个数，如果s2的某个窗口恰好包含这个字典，认为s1是s2的子串
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] dic = new int[26];
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        for (char ch : s1CharArray) {
            dic[ch - 97]++;
        }
        for (int i = 0; i < n; i++) {
            dic[s2CharArray[i] - 97]--;
        }
        if (check(dic)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            dic[s2CharArray[i] - 97]--;
            dic[s2CharArray[i - n] - 97]++;
            if (check(dic)) {
                return true;
            }
        }
        return false;
    }
    private boolean check(int[] dic) {
        for (int x : dic) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
