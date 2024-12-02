package leetcode.lcsaf.binary_search;

import java.util.Arrays;

public class 绝对差值和 {
    /**
     * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
     *
     * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
     *
     * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
     *
     * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
     *
     * |x| 定义为：
     *
     * 如果 x >= 0 ，值为 x ，或者
     * 如果 x <= 0 ，值为 -x
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9 + 7);
        int sum = 0;
        int[] flag = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            flag[i] = Math.abs(nums1[i] - nums2[i]);
            sum += flag[i];
            sum %= MOD;
        }
        int mx = 0;
        int[] copyOf = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(copyOf);
        for (int i = 0; i < nums2.length; i++) {
            int idx = binary_search(copyOf, nums2[i]);
            if (idx == -1) {
                mx = Math.max(mx, flag[i] - Math.abs((copyOf[idx + 1] - nums2[i])));
            } else if (idx >= copyOf.length - 1) {
                mx = Math.max(mx, flag[i] - Math.abs(nums2[i] - copyOf[copyOf.length - 1]));
            } else {
                mx = Math.max(mx, flag[i] - Math.abs(Math.min(nums2[i] - copyOf[idx], copyOf[idx + 1] - nums2[i])));
            }
        }
        return ((sum + MOD) - mx) % MOD;
    }

    private int binary_search(int[] nums1, int target) {
        int left = -1, right = nums1.length;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (nums1[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
