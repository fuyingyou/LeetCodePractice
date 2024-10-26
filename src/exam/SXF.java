package exam;

import java.util.Arrays;
import java.util.Scanner;

public class SXF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            Arrays.sort(arr, (a, b)-> a[1] - b[1]);
            boolean can = true;
            int state = 0;
            for(int j = 0; j < n; j++){
                if(arr[j][0] == 1){
                    if(state == 0) {
                        state = 1;
                    } else if(state == -1){
                        state = 1;
                    }
                }else if(arr[j][0] == -1){
                    if(state == 0){
                        can = false;
                        break;
                    }
                    else if(state == 1){
                        state = -1;
                    }
                }

            }
            if(state == 1) can = false;
            System.out.println(can ? "YES" : "NO");
        }
    }
}
