package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {

    public static void main(String[] args) {
        String file1 = "Y:\\fyy\\diff1.txt";
        String file2 = "Y:\\fyy\\diff2.txt";

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));

            int lineNumber = 1;
            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    int columnNumber = findFirstDifferenceIndex(line1, line2);
                    System.out.println("第一个不同之处在第 " + lineNumber + " 行，第 " + columnNumber + " 列");
                    break;
                }
                lineNumber++;
            }

            reader1.close();
            reader2.close();

        } catch (IOException e) {
            System.err.println("读取文件时出错: " + e.getMessage());
        }
    }

    public static int findFirstDifferenceIndex(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i + 1;
            }
        }
        return minLength + 1;
    }
}
