package leetcode.lcsaf.差分数组;

public class 字母移位2 {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] chafen = new int[n + 1];
        for (int[] arr : shifts) {
            int x = arr[2] == 0 ? -1 : 1;
            chafen[arr[0]] += x;
            chafen[arr[1] + 1] -= x;
        }
        for (int i = 1; i < n + 1; i++) {
            chafen[i] += chafen[i - 1];
        }
        for (int i = 0; i < n; i++) {
            charArray[i] = (char) ((charArray[i] - 97 + 26 + (chafen[i] % 26)) % 26 + 97);
        }
        return new String(charArray);
    }
}
