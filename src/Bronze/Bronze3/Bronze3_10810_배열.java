package Bronze.Bronze3;

import java.util.Scanner;

public class Bronze3_10810_배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int k = sc.nextInt();

            for (int j = num1 - 1; j < num2; j++) {
                arr[j] = k;
            }
        }

        for (int result : arr) {
            System.out.print(result + " ");
        }
    }
}
