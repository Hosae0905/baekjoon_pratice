package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_10870_재귀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(fibo(N));
    }

    private static int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

//        return n + fibo(n - 1);       // 이렇게 작성하면 n == 0일때를 검증하지 못한다.
        return fibo(n - 1) + fibo(n - 2);
    }
}
