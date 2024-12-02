package written_examination;

import java.util.Scanner;
public class guangda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            String encrypted = encrypt(s, n);
            System.out.println(encrypted.charAt((int) (k - 1)));
        }
    }
    public static String encrypt(String s, long n) {
        if (n == 0) {
            return s;
        }
        StringBuilder encrypted = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'A') {encrypted.append("BC");
            } else if (c == 'B') {encrypted.append("CA");
            } else if (c == 'C') {encrypted.append("AB");
            }
        }
        return encrypt(encrypted.toString(), n - 1);
    }
}