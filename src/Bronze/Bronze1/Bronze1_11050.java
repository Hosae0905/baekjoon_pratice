package Bronze.Bronze1;

import java.util.Scanner;

public class Bronze1_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int result = factorial(N) / (factorial(N - K) * factorial(K));
        System.out.println(result);
    }

    private static int factorial(int N) {
        if (N <= 1) return 1;
        else return factorial(N - 1) * N;
    }
}
