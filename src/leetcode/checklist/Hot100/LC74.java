package leetcode.checklist.Hot100;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        while (i + 1 < n && matrix[i + 1][0] <= target) {
            i++;
        }
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
