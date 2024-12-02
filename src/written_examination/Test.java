package written_examination;

import java.math.BigInteger;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        List<BigInteger> numbers = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    numbers.add(new BigInteger(temp.toString()));
                    temp = new StringBuilder();
                }
            }
        }
        if (temp.length() > 0) {
            numbers.add(new BigInteger(temp.toString()));
        }
        numbers.sort((a, b) -> b.compareTo(a));
        if (k > numbers.size() || k <= 0) {
            System.out.println("N");
        } else {
            System.out.println(numbers.get(k - 1));
        }
    }
}