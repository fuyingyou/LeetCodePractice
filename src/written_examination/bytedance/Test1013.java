package written_examination.bytedance;

import java.util.*;

public class Test1013 {
    static boolean[] isVowels = new boolean[26];
    static {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char ch : vowels) {
            isVowels[ch - 'a'] = true;
        }
    }

    public static int longest(char[] chs, int n) {
        if (n < 2) {
            return n;
        }
        List<Integer> vowelIdxs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = chs[i];
            if (isVowels[ch - 'a']){
                sb.append(ch);
                vowelIdxs.add(i);
            }
        }
        int mx = 0;
        if (vowelIdxs.isEmpty()) {
            return n;
        }
        char[] array = sb.toString().toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < array.length; i++) {
            dp[i][i] = true;
            mx = 1;
        }

//        String transformer = transFromString(V);
//        int[] P = new int[transformer.length()];
//        int center = 0, right = 0;
//        for (int i = 0; i < transformer.length(); i++) {
//            int mirror = 2 * center - i;
//            if (i < right) {
//                P[i] = Math.min(right - i, P[mirror]);
//            }
//            while (i + P[i] + 1 < transformer.length() && i - P[i] - 1 >= 0 && transformer.charAt(i + P[i] + 1) == transformer.charAt(i - P[i] - 1)) {
//                P[i]++;
//            }
//            if (i + P[i] > right) {
//                center = i;
//                right = i + P[i];
//            }
//            int len = P[i];
//            if (len > 0) {
//                int start = i - len;
//                int end=  i + len;
//                int startV =  start / 2;
//                int endV = end / 2 - 1;
//                if (transformer.charAt(i) != '#') {
//                    endV = end / 2;
//                }
//                startV = Math.max(0, startV);
//                endV = Math.min(vowelIdxs.size() - 1, endV);
//                int startIdx = vowelIdxs.get(startV);
//                int endIdx = vowelIdxs.get(endV);
//                int curLen = endIdx - startIdx + 1;
//                mx = Math.max(mx, curLen);
//
//            }
//        }
        int mxC = find(chs, n);
        return Math.max(mx, mxC);
    }

    static String transFromString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char ch : str.toCharArray()) {
            sb.append(ch).append('#');
        }
        return sb.toString();
    }

    static int find(char[] chs, int n) {
        int mxC = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            if (!isVowels[chs[i] - 'a']) {
                cur++;
                if (cur > mxC) {
                    mxC = cur;
                }
            } else {
                cur = 0;
            }
        }
        return mxC;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] chsStr = s.toCharArray();
        System.out.println(longest(chsStr, n));
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String s = in.next();
//        char[] chsStr = s.toCharArray();
//        int mx = 0;
//        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//            mx = 1;
//        }
//        for (int len = 2; len <= n; len++) {
//            for (int i = 0; i <= n - len; i++) {
//                int j = i + len - 1;
//                if (chsStr[i] == chsStr[j]) {
//                    if (len == 2 || dp[i + 1][j - 1]) {
//                        dp[i][j] = true;
//                        if (f(chsStr, n, i , j + 1)) {
//                            mx = Math.max(mx, len);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(mx);
//    }

    static boolean isYuan(char ch) {
        char[] yuan = {'a', 'e', 'i', 'o', 'u'};
        if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
            return false;
        }
        return true;
    }

    static boolean f(char[] chs, int n, int i , int j) {
        for (; i <= j; i++) {
//            if () {
//                return true;
//            }
        }
        return true;
    }

    static int isHuiWen(char[] chs, int n, int i , int j) {
        while (i >= 0 && j < n) {
            if (chs[i] == chs[j] || ((!isYuan(chs[i])) && (!isYuan(chs[j])))) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return (j - 1) - (i + 1) + 1;
    }
}
