package leetcode.contest;

import java.util.*;

public class week421 {
    public long maxScore(int[] nums) {
        if (nums.length == 1) {
            return (long) nums[0] * nums[0];
        }
        Arrays.sort(nums);
        long res = 0;
        long gcd = nums[1];
        long lcm = nums[1];
        for (int i = 2; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
            lcm = lcm(lcm, nums[i]);
        }
        res = gcd * lcm;

        for (int i = 1; i < nums.length; i++) {
            gcd = nums[0];
            lcm = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
            }
            res = Math.max(res, gcd * lcm);
        }

        gcd = nums[0];
        lcm = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
            lcm = lcm(lcm, nums[i]);
        }
        res = Math.max(res, gcd * lcm);
        return res;
    }
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public int lengthAfterTransformations(String s, int t) {
        int mod = (int) (1e9 + 7);
        int[] dic = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            dic[c - 'a']++;
            dic[c - 'a'] %= mod;
        }
        while (t-- > 0) {
            int temp = dic[25];
            for (int i = 25; i > 0; i--) {
                dic[i] = dic[i - 1];
                dic[i] %= mod;
            }
            dic[0] = temp;
            dic[0] %= mod;
            dic[1] += temp;
            dic[1] %= mod;
        }
        int sum = 0;
        for (int num : dic) {
            sum += num;
            sum %= mod;
        }
        return sum;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int mod = (int) (1e9 + 7);
        int[] dic = new int[26 + 1];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            dic[c - 'a'] = (dic[c - 'a'] + 1) % mod;
        }
        while (t-- > 0) {
            int[] temp = new int[27];
            for (int i = 0; i < 26; i++) {
                int x = nums.get(i);
                temp[i + 1] += dic[i];
                temp[Math.min(26, i + x + 1)] -= dic[i];
                if (i + x + 1 > 26) {
                    temp[0] += dic[i];
                    temp[(i + x + 1) % 26] -= dic[i];
                }
            }
            for (int i = 1; i < 26 + 1; i++) {
                temp[i] += temp[i - 1];
                temp[i] %= mod;
            }
            dic = temp;
            for (int x : dic) {
                System.out.print(x);
            }
            System.out.println();
        }

        for (int i = 1; i < 26 + 1; i++) {
            dic[i] += dic[i - 1];
        }

        int sum = 0;
        for (int num : dic) {
            sum += num;
            sum %= mod;
        }
        return sum;
    }
}
