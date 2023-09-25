package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_10813_배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int temp;
            int T = sc.nextInt();
            int F = sc.nextInt();

            temp = arr[T - 1];
            arr[T - 1] = arr[F - 1];
            arr[F - 1] = temp;
        }

        for (int result : arr) {
            System.out.print(result + " ");
        }
    }
}
