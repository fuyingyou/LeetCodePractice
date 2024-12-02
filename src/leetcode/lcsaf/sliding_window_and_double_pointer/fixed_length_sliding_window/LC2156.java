package leetcode.lcsaf.sliding_window_and_double_pointer.fixed_length_sliding_window;

public class LC2156 {

    /**
     * 从左向右时，需要除以power, 因为已经取余，所以除以power不一定余数为0
     * 从右向左时，需要取出最大的那个数，可以直接去掉取余后的结果，然后整体 * power,还可以使用秦九韶算法
     * @param s
     * @param power
     * @param modulo
     * @param k
     * @param hashValue
     * @return
     */
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
