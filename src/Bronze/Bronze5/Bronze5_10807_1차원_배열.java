package Bronze.Bronze5;

import java.util.Scanner;

public class Bronze5_10807_1차원_배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] M = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            M[i] = sc.nextInt();
        }

        int v = sc.nextInt();

        for (int i = 0; i < M.length; i++) {
            if (M[i] == v) {
                count++;
            }
        }
        System.out.println(count);
    }
}
