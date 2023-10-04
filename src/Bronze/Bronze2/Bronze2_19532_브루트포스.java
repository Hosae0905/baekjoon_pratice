package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_19532_브루트포스 {
    public static void main(String[] args) {
        // 입력값
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int X = 0;
        int Y = 0;

        // 반복문 X는 0부터 Y는 1부터
        // ax + by = c  && cx + dy = e
        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    X = x;
                    Y = y;
                }
            }
        }

        System.out.println(X + " " + Y);
    }
}
