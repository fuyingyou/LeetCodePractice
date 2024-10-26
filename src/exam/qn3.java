package exam;

import java.util.*;

public class qn3 {
//    static class State implements Comparable<State> {
//        int node, time;
//        long f;
//        public State(int node, int time, long f) {
//            this.node = node;
//            this.time = time;
//            this.f = f;
//        }
//        @Override
//        public int compareTo(State o) {
//            return Long.compare(this.f, o.f);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[][] edge  = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                edge[i][j] = in.nextInt();
//            }
//        }
//
//        long maxValue = Long.MAX_VALUE >> 1;
//        for (int i = 0; i < n; i++) {
//            long[][] dist = new long[n][m + 1];
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(dist[i], maxValue);
//            }
//            dist[i][0] = 0;
//            PriorityQueue<>
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 输入数组长度n
//        int n = scanner.nextInt();
//
//        // 输入数组a
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//
//        // 找到最小值及其第一个和最后一个位置
//        int min = a[0];
//        int firstPos = 0;
//        int lastPos = 0;
//
//        for (int i = 1; i < n; i++) {
//            if (a[i] < min) {
//                min = a[i];
//                firstPos = i;
//                lastPos = i;
//            } else if (a[i] == min) {
//                lastPos = i;
//            }
//        }
//
//        // 输出结果，位置+1是为了转换为1-based索引
//        System.out.println((firstPos + 1) + " " + (lastPos + 1));
//    }
//        /    static int n, m;
//    static char[][] grid;
//    static boolean[][] visited;
//    static int[] dx = {0, 1}; // 0表示右移，1表示下移
//    static int[] dy = {1, 0}; // 1表示右移，0表示下移
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 输入网格的大小
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        scanner.nextLine();  // 读取换行符
//
//        grid = new char[n][m];
//        visited = new boolean[n][m];
//
//        // 输入网格图
//        for (int i = 0; i < n; i++) {
//            String line = scanner.nextLine();
//            grid[i] = line.toCharArray();
//        }
//
//        int result = bfs(0, 0);
//        System.out.println(result);
//    }
//
//    static int bfs(int startX, int startY) {
//        // 初始位置必须是 '*'
//        if (grid[startX][startY] != '*') return -1;
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{startX, startY, 0}); // 初始位置, 第三项为步数
//        visited[startX][startY] = true;
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int x = current[0];
//            int y = current[1];
//            int steps = current[2];
//
//            // 到达右下角，且是 '*'
//            if (x == n - 1 && y == m - 1 && grid[x][y] == '*') {
//                return steps;
//            }
//
//            // 遍历两个方向，分别为下移和右移
//            for (int j = 0; j < 2; j++) {
//                // 尝试跳跃
//                for (int jump = 1; jump < Math.max(n, m); jump++) {
//                    moveAndCheck(queue, x, y, steps, dx[j], dy[j], jump);
//                }
//            }
//        }
//
//        return -1;  // 无法到达
//    }
//
//    // 尝试移动指定的步数，检测是否有效
//    static void moveAndCheck(Queue<int[]> queue, int x, int y, int steps, int dx, int dy, int distance) {
//        int newX = x + dx * distance;
//        int newY = y + dy * distance;
//
//        // 检查新位置是否合法，是否已经访问过，以及是否为 '*'
//        if (isValid(newX, newY) && grid[newX][newY] == '*' && !visited[newX][newY]) {
//            visited[newX][newY] = true; // 标记为已访问
//            queue.offer(new int[]{newX, newY, steps + 1}); // 步数加1
//        }
//    }
//
//    // 检查坐标是否合法
//    static boolean isValid(int x, int y) {
//        return x >= 0 && x < n && y >= 0 && y < m;
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1]) {
                r = nums[i - 1] - 1;
            } else {
                l = nums[i - 1] + 1;
            }
            if (r < l) {
                System.out.println(0);
                return;
            }
        }
        if (nums[n - 1] < l || nums[n - 1] > r) {
            System.out.println(0);
            return;
        }
        System.out.println(Math.max(0, nums[n - 1] - 1 - l + 1) + Math.max(0, r - (nums[n - 1] + 1) + 1));
    }
}
