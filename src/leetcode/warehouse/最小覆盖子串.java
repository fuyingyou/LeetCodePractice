package leetcode.warehouse;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        String ans = "";
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return ans;
        }
        int[] dic = new int[52];
        for (char ch : t.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                dic[ch - 'a' + 26]++;
            } else {
                dic[ch - 'A']++;
            }
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (charArray[i] >= 'a' && charArray[i] <= 'z') {
                dic[charArray[i] - 'a' + 26]--;
                if (dic[charArray[i] - 'a' + 26] <= 0 && checkArray(dic)) {
                    while (left < i && checkArray(dic)) {
                        if (charArray[left] >= 'a' && charArray[left] <= 'z') {
                            dic[charArray[left] - 'a' + 26]++;
                        } else {
                            dic[charArray[left] - 'A']++;
                        }
                        left++;
                    }
                    if (i + 1 - Math.max(left - 1, 0) < ans.length() || ans.isEmpty()) {
                        ans = s.substring(Math.max(left - 1, 0), i + 1);
                    }

                }
            } else {
                dic[charArray[i] - 'A']--;
                if (dic[charArray[i] - 'A'] <= 0 && checkArray(dic)) {
                    while (left < i && checkArray(dic)) {
                        if (charArray[left] >= 'a' && charArray[left] <= 'z') {
                            dic[charArray[left] - 'a' + 26]++;
                        } else {
                            dic[charArray[left] - 'A']++;
                        }
                        left++;
                    }
                    if (i + 1 - Math.max(left - 1, 0) < ans.length() || ans.isEmpty()) {
                        ans = s.substring(Math.max(left - 1, 0), i + 1);
                    }
                }
            }
        }

        return ans;
    }

    private boolean checkArray(int[] dic) {
        for (int x : dic) {
            if (x > 0) {
                return false;
            }
        }
        return true;
    }
}
