package leetcode.滑动窗口.定长滑动窗口;

public class 滑动子数组的美丽值 {
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
