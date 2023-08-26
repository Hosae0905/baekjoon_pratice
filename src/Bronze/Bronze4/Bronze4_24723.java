package Bronze.Bronze4;

import java.util.Scanner;

public class Bronze4_24723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;

        for (int block = 1; block <= N; block++) {
            count *= 2;
        }


        System.out.println(count);
    }
}
