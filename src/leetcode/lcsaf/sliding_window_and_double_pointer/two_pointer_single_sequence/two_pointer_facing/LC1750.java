package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_single_sequence.two_pointer_facing;

public class LC1750 {
    /**
     * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
     *
     * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
     * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
     * 前缀和后缀在字符串中任意位置都不能有交集。
     * 前缀和后缀包含的所有字符都要相同。
     * 同时删除前缀和后缀。
     * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度。
     * 1 <= s.length <= 10e5
     * s 只包含字符 'a'，'b' 和 'c' 。
     */
    public int minimumLength(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right && charArray[left] == charArray[right]) {
            char temp = charArray[left];
            while (left <= right && charArray[left] == temp) {
                left++;
            }
            while (left <= right && charArray[right] == temp) {
                right--;
            }
        }
        return right - left + 1;
    }
}
