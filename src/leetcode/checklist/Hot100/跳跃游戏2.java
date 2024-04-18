package leetcode.checklist.Hot100;

public class 跳跃游戏2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int mx = 0;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            mx = Math.max(mx,  i + nums[i]);
            if (i == end) {
                end = mx;
                sum++;
            }
        }
        return sum;
    }
}
