package leetcode.warehouse;

public class LC2653 {
    /**
     * /**
     *  题目范围显示num的值为【-50， 50】，可以建立dic记录此窗口内的每种负数的个数，同时记录此窗口内的所有负数的个数和
     *  if 负数个数总和 < x ： 0
     *  if 小于负数Y的负数个数 < k, 小于等于负数Y的负数个数 >=k ： Y
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // 记录负数个数
        int[] dic = new int[50];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                cnt++;
                dic[nums[i] + 50]++;
            }
        }
        if (cnt >= x) {
            int temp = 0;
            for (int i = 0; i < 50; i++) {
                // 第x小 ： 小于num的数的个数 < x， 加上num后数的个数 >= x
                if (temp < x && temp + dic[i] >= x) {
                    res[0] = i - 50;
                }
                temp += dic[i];
            }
        } else {
            res[0] = 0;
        }

        for (int i = k; i < n; i++) {
            if (nums[i] < 0) {
                cnt++;
                dic[nums[i] + 50]++;
            }
            if (nums[i - k] < 0) {
                cnt--;
                dic[nums[i - k] + 50]--;
            }
            if (cnt >= x) {
                int temp = 0;
                for (int j = 0; j < 50; j++) {
                    if (temp < x && temp + dic[j] >= x) {
                        res[i - k + 1] = j - 50;
                    }
                    temp += dic[j];
                }
            } else {
                res[i - k + 1] = 0;
            }
        }
        return res;
    }
}
