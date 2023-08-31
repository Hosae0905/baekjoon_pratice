package Bronze.Bronze4;

import java.util.Scanner;

public class Bronze4_2480_조건문 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int result = 0;
        int max = 0;

        if (A == B && B == C) result = 10000 + (A * 1000);
        else if (A == B && A != C) {
            result = 1000 + (A * 100);
        } else if (A == C && A != B) {
            result = 1000 + (A * 100);
        } else if (B == C && B != A) {
            result = 1000 + (B * 100);
        } else if (A != B && B != C && A != C) {
            if (A > B && A > C) max = A;
            else if (B > A && B > C) max = B;
            else max = C;
            result = max * 100;
        }

        System.out.println(result);
    }
}
