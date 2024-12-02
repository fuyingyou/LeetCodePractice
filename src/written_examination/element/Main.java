package written_examination.element;

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Element {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[][] board = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                board[i][j] = scanner.nextInt();
//            }
//        }
//        int q = scanner.nextInt();
//        for (int k = 0; k < q; k++) {
//            int x1 = scanner.nextInt();
//            int y1 = scanner.nextInt();
//            int x2 = scanner.nextInt();
//            int y2 = scanner.nextInt();
//            int[] exit = findExit(board, x1, y1, x2, y2);
//            System.out.println(exit[0] + " " + exit[1]);
//        }
//        scanner.close();
//    }
//
//    public static int[] findExit(int[][] board, int x1, int y1, int x2, int y2) {
//        int row = x1;
//        int col = y1;
//        while (row <= x2 && col <= y2) {
//            if (board[row][col] == 0) {
//                row++;
//            } else {
//                col++;
//            }
//        }
//        if (row > x2) {
//            row = x2;
//        }
//        if (col > y2) {
//            col = y2;
//        }
//        return new int[]{row, col};
//    }
//}

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            sum += x;
            pq.add(x);
        }
        int ave = (int) sum / n;
        int len = (int) (n - (sum % n));
        for (int i = 0; i < len; i++) {
            int y = pq.poll();
            if (y < ave) {
                res += ave - y;
            }
        }
        for (int i = len; i < n; i++) {
            int y = pq.poll();
            if (y < ave + 1) {
                res += ave + 1 - y;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class Main {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = scanner.nextInt();
//            int m = findM(n);
//            System.out.println(m);
//        }
//        scanner.close();
//    }
//
//    private static int findM(int n) {
//        for (int m = 2; m <= n; m++) {
//            int gcd = gcd(n, m);
//            if (isPrime(gcd)) {
//                return m;
//            }
//        }
//        return -1;
//    }
//
//    private static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        } else {
//            return gcd(b, a % b);
//        }
//    }
//
//    private static boolean isPrime(int num) {
//        if (num <= 1) {
//            return false;
//        }
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        // Read input data
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//
//        // Calculate the original sum
//        long sum = 0;
//        for (int number : numbers) {
//            sum += number;
//        }
//
//        // Check special cases
//        if (k == 1 || k == -1) {
//            System.out.println(sum);
//            return;
//        }
//
//        // Find the minimum and maximum sums
//        long minSum = sum;
//        long maxSum = sum;
//        for (int i = 0; i < n; i++) {
//            long leftSum = sum - numbers[i];
//            long rightSum = sum - numbers[(i + 1) % n];
//
//            long leftProduct = leftSum * Math.abs(k);
//            long rightProduct = rightSum * Math.abs(k);
//
//            minSum = Math.min(minSum, Math.min(leftSum, rightSum));
//            maxSum = Math.max(maxSum, Math.max(leftProduct, rightProduct));
//        }
//
//        // Output the result
//        System.out.println(maxSum);
//    }
//}