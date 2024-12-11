package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_fixed_length;

public class LC1456 {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        int ans = 0;
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < k; i++) {
            if (check(charArray[i])) {
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
        for (int i = k; i < n; i++) {
            if (check(charArray[i])) {
                cnt++;
            }
            if (check(charArray[i - k])) {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    private boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
