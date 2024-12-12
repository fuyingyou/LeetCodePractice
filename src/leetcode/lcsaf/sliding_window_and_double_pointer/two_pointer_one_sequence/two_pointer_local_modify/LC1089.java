package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_one_sequence.two_pointer_local_modify;

public class LC1089 {
    /**
     * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     *
     * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     *
     *1 <= arr.length <= 10e4
     * 0 <= arr[i] <= 9
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int left = -1;
        while (sum < n) {
            if (arr[++left] == 0) {
                sum += 2;
            } else {
                sum += 1;
            }
        }
        if (sum == n + 1) {
            arr[--n] = 0;
            left--;
        }
        while (left >= 0) {
            if (arr[left] == 0) {
                arr[--n] = 0;
                arr[--n] = 0;
            } else {
                arr[--n] = arr[left];
            }
            left--;
        }
    }
}
