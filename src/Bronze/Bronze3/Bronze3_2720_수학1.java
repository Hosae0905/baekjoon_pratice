package Bronze.Bronze3;

import java.util.Scanner;

public class Bronze3_2720_수학1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] C = new int[T];
        int Q = 25;
        int D = 10;
        int N = 5;
        int P = 1;

        for (int i = 0; i < T; i++) {
            C[i] = sc.nextInt();
        }

        for (int i = 0; i < C.length; i++) {
            sb.append(C[i] / Q + " ");
            C[i] %= Q;
            sb.append(C[i] / D + " ");
            C[i] %= D;
            sb.append(C[i] / N + " ");
            C[i] %= N;
            sb.append(C[i] / P + "\n");
        }

        System.out.println(sb);
    }
}
