package leetcode.daily_question.month11;

public class Q1118{
    /**
     * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
     *
     * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
     *
     * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
     */
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];
        int[][] p = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int cnt = 0;
                for(int[] pp: p) {
                    int row = i + pp[0];
                    int col = j + pp[1];
                    if (row >= 0 && row < n && col >= 0 && col < m) {
                        sum += img[row][col];
                        cnt++;
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }
}
