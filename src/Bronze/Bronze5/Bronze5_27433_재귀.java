package Bronze.Bronze5;

import java.util.Scanner;

public class Bronze5_27433_재귀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(factorial(N));
    }

    private static long factorial(int n) {
        /*int result = 0;
        result *= factorial(n - 1);

        if (n > 0) {
            return result;
        } else {
            return 1;
        }*/

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
