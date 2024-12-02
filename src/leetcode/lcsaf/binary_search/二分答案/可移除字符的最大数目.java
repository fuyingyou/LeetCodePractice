package leetcode.lcsaf.binary_search.二分答案;

public class 可移除字符的最大数目 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = -1, right = removable.length + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(s, p, mid, removable)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(String s, String p, int mid, int[] removable) {
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        for (int i = 0; i < mid; i++) {
            sCharArray[removable[i]] = '0';
        }
        int i = 0, j = 0, n = s.length(), m = p.length();
        while (i < n && j < m) {
            while (i < n && sCharArray[i] != pCharArray[j]) {
                i++;
            }
            i++;
            j++;
        }
        return i < n + 1 && j == m;
    }
}
