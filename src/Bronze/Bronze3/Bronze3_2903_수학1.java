package Bronze.Bronze3;

import java.util.Scanner;

public class Bronze3_2903_수학1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int X = 2;
        int Y = 2;
        int k = 1;

        for (int i = 1; i <= N; i++) {
            X += k;
            Y += k;
            k *= 2;
        }

        System.out.println(X * Y);
    }
}
