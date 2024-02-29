package leetcode.滑动窗口.定长滑动窗口;

public class 字符串的排列 {
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
