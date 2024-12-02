package leetcode.warehouse;

public class 统计满足K约束的子字符串数量 {
    /**
     * 给你一个 二进制 字符串 s 和一个整数 k。
     *
     * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
     *
     * 字符串中 0 的数量最多为 k。
     * 字符串中 1 的数量最多为 k。
     * 返回一个整数，表示 s 的所有满足 k 约束 的
     * 子字符串
     * 的数量。
     */
    public int countKConstraintSubstrings(String s, int k) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        int[] cnt = new int[2];
        int left = 0;
        for (int i = 0; i < charArray.length; i++) {
            cnt[charArray[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[charArray[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }

    /**
     * 给你一个 二进制 字符串 s 和一个整数 k。
     *
     * 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
     *
     * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
     *
     * 字符串中 0 的数量最多为 k。
     * 字符串中 1 的数量最多为 k。
     * 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的
     * 子字符串
     * 的数量。
     *
     */
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        char[] charArray = s.toCharArray();
        int[] left = new int[n];
        long[] sum = new long[n + 1];
        int[] cnt = new int[2];
        int l = 0;

        for (int i = 0; i < n; i++) {
            cnt[charArray[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[charArray[l] & 1]--;
                l++;
            }
            left[i] = l;
            sum[i + 1] = sum[i] + i - l + 1;
        }

        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            int ql = queries[i][0];
            int qr = queries[i][1];
            int j = lowerBound(left, ql - 1, qr + 1, ql);
            ans[i] = sum[qr + 1] - sum[j] + (long)(j - ql + 1) * (j - ql) / 2;
        }
        return ans;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        while (left + 1 < right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
