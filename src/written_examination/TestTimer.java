package written_examination;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
//    static Timer timer = new Timer();
//
//    public void testSum() {
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//                threadLocal.set(100);
//                Integer temp = threadLocal.get();
//                for (int i = 0; i <= 100; i++) {
//                    temp += i;
//                }
//                threadLocal.set(temp);
//                System.out.println(temp);
//            }
//        }, 20);
//    }
//    public void testDivision (){
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                ThreadLocal<Integer> threadLocal =new ThreadLocal<>();
//                threadLocal.set(100);
//                Integer temp = threadLocal.get();
//                for(int i=10;i>=0;i--){
//                    temp /= i;
//                }
//                threadLocal.set(temp);
//                System.out.println(temp);
//            }
//        }, 10);
//    }

//    public static void main(String[] args) {
//        written_examination.TestTimer testTimer =  new written_examination.TestTimer();
//        testTimer.testSum();
//        testTimer.testDivision();
//    }
//ocwon der
//o dnowc er
//od ecwon r
//oder nowc
//
//cwon oder
//c onow der
//co dwon er
//cod enow r
//coder won
//
//won coder
//w cno oder
//wc oon der
//wco dno er
//wcod eon r
//wcoder no
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        String str1 = str.substring(k - 1);
        String substring = str.substring(0, k - 1);
        String str2;
        if ((n - k) % 2 == 1) {
            str2 = substring;
        } else {
            str2 = new StringBuilder(substring).reverse().toString();
        }
        System.out.println(str1 + str2);
    }
}
