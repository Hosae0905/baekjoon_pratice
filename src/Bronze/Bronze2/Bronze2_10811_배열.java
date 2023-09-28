package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_10811_배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            int T = sc.nextInt() - 1;
            int K = sc.nextInt() - 1;

            while (T < K) {
                int temp;
                temp = result[T];
                result[T++] = result[K];
                result[K--] = temp;
            }
        }

        for (int str : result) {
            System.out.print(str + " ");
        }
    }
}
