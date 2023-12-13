package leetcode.bank;

public class 字典序最小回文串 {
    public String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n / 2; i++) {
            if (charArray[i] > charArray[n - 1 - i]) {
                charArray[i] = charArray[n - 1 - i];
            } else if (charArray[i] < charArray[n - 1 - i]) {
                charArray[n - 1 - i] = charArray[i];
            }

        }
        return String.valueOf(charArray);
    }
}
