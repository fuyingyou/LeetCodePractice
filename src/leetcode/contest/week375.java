package leetcode.contest;

import java.util.*;
public class week375 {
    public static void main(String[] args) {

    }

    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                ans++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return ans;
    }

    int mod = (int) (1e9 + 7);
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (variables[i][3] < target) {
                continue;
            }
            int temp = 1;
            variables[i][0] %= 10;
            for (int j = 0; j < variables[i][1]; j++) {
                temp *= variables[i][0];
                temp %= 10;
            }
            int x = temp;
            for (int j = 0; j < variables[i][2] - 1; j++) {
                temp *= x;
                temp %= variables[i][3];
            }
            if (temp == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = nums.length, sum = 0, left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == mx) {
                sum++;
            }
            while (sum == k) {
                if (nums[left++] == mx) {
                    sum--;
                }
            }
            ans += left;
        }
        return ans;
    }

}
