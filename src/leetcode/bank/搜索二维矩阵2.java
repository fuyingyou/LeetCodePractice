package leetcode.bank;

public class 搜索二维矩阵2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0, y = 0;

        // 排除后面的列
        while (y + 1 < m && matrix[x][y + 1] <= target) {
            y++;
        }
        while (true) {

            // 如果可以向下则向下
            while (x + 1 < n && matrix[x + 1][y] <= target) {
                x++;
            }

            // 不能继续变大: 查看当前值是否为目标值
            if (x + 1 < n) {
                if (matrix[x][y] == target) {
                    return true;
                } else {
                    // 继续变大无意义，降低当前值后，继续搜寻
                    y--;
                    if (y < 0) {
                        return false;
                    }
                }

            } else {
                // 不能继续变大，且为当前范围的最大值
                return matrix[x][y] == target;
            }
        }
    }
}
