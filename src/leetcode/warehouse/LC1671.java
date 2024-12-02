package leetcode.warehouse;

import java.util.ArrayList;

public class LC1671 {
    public int minimumMountainRemovals(int[] nums) {
        var list = new ArrayList<Integer>();
        int n = nums.length;
        var lis = new int[n];
        var lds = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = bin_search(list, nums[i]);
            if (idx == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(idx, nums[i]);
            }
            lis[i] = idx + 1;
        }
        list.clear();
        for (int i = n - 1; i >= 0; i--) {
            int idx = bin_search(list, nums[i]);
            if (idx == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(idx, nums[i]);
            }
            lds[i] = idx + 1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, n - lis[i] - lds[i] + 1);
        }
        for(int x : lis) {
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : lds) {
            System.out.print(x + " ");
        }
        System.out.println();
        return ans;
    }

    private int bin_search(ArrayList<Integer> list, int num) {
        int right = list.size(), left = -1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) >= num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}
