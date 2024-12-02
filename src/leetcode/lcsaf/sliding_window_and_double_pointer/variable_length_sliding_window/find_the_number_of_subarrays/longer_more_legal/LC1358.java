package leetcode.lcsaf.sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.longer_more_legal;

public class LC1358 {
    /**
     * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
     * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
     */
    public int numberOfSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] dic = new int[3];
        int cnt = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            dic[charArray[right] - 'a']++;
            if (dic[charArray[right] - 'a'] == 1) {
                cnt++;
                while (cnt == 3) {
                    ans += n - right;
                    dic[charArray[left] - 'a']--;
                    if (dic[charArray[left] - 'a'] == 0) {
                        cnt--;
                    }
                    left++;
                }
            }
        }
        return ans;
    }
}
