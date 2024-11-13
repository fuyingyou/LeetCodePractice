package leetcode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class 检查一个字符串是否包含所有长度为K的二进制子串 {
    /**
     * 给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
     */
    public boolean hasAllCodes(String s, int k) {
        char[] charArray = s.toCharArray();
        Set<String> set = new HashSet<>();
        int target = 1 << k;
        for (int i = k; i <= s.length(); i++) {
            System.out.println(new String(charArray, i - k, k));
            set.add(new String(charArray, i - k, k));
        }
        return set.size() == target;
    }
}
