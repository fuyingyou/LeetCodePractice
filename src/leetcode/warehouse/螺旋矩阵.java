package leetcode.warehouse;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        var ans = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
            }
            if (top > --bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
