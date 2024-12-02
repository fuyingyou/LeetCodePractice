package leetcode.lcsaf.滑动窗口;

public class Test2516 {
    public int takeCharacters(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        int[] cnt = new int[3];
        for (char c : charArray) {
            cnt[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int ans = -1;
        while (right < n) {
            int idx = charArray[right] - 'a';
            cnt[idx]--;
            while (cnt[idx] < k) {
                cnt[charArray[left] - 'a']++;
                left++;
            }
            ans = Math.max(ans, n - (right - left + 1));
            right++;
        }
        return ans;
    }
}
