package leetcode.warehouse;

public class LC2134 {
    /**
     *  数字1的总数是确定的cnt，最后所有的1需要在一个长为cnt的窗口中
     *  先得到数字1的数量，然后滑动这个大小的窗口，记录窗口内数字1最多出现了几次，不在这个窗口内的数字1就是需要交换过来的。
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                cnt++;
            }
        }
        int mx = 0;
        int temp = 0;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == 1) {
                temp++;
            }
        }
        mx = Math.max(mx, temp);
        for (int i = cnt; i < n + cnt - 1; i++) {
            if (nums[i - cnt] == 1) {
                temp--;
            }
            if (nums[i % n] == 1) {
                temp++;
            }
            mx = Math.max(mx, temp);
        }
        return cnt - mx;
    }
}
