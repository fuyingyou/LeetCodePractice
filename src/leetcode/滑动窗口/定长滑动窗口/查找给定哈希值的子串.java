package leetcode.滑动窗口.定长滑动窗口;

public class 查找给定哈希值的子串 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        long sum = 0;
        long x = 1;
        for (int i = n - k; i < n; i++) {
            sum += (charArray[i] - 'a' + 1) * x;
            sum %= modulo;
            x *= power;
            x %= modulo;
        }
        System.out.println(sum);
        if (sum == hashValue) {
            return s.substring(n - k, n);
        }
        for (int i = n - k - 1; i >= 0; i--) {
            sum = (sum * power + charArray[i] - 'a' + 1 - (charArray[i + k] - 'a' + 1) * x % modulo + modulo) % modulo;
            if (sum == hashValue) {
                return s.substring(i, i + k);
            }
            System.out.println(sum);
        }
        return s;
    }
}
