package Bronze.Bronze5;

import java.util.Scanner;

public class Bronze5_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[28];
        int[] M = new int[30];
        int count = 1;
        for (int i = 0; i < N.length; i++) {
            N[i] = sc.nextInt();
        }

        for (int i = 0; i < M.length; i++) {
            M[i] = count++;
        }

        for (int i = 0; i < N.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (N[i] == M[j]) M[j] -= N[i];
            }
        }

        for (int i = 0; i < M.length; i++) {
            if (M[i] != 0 ) System.out.println(M[i]);
        }
    }
}
