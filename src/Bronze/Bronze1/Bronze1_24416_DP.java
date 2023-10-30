package Bronze.Bronze1;

import java.io.*;

public class Bronze1_24416_DP {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        fib(N);
        sb.append(count).append(" ");
        fibonacci(N);
        sb.append(count);

        System.out.println(sb);
    }

    private static int fibonacci(int n) {
        count = 0;
        int[] f = new int[n];
        f[0] = f[1] = 1;
        for (int i = 2; i < n; i++) {
            count++;
            f[i] = f[n - 1] + f[n - 2];
        }
        return f[n - 1];
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }

    }

}
