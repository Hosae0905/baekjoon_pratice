package Bronze.Bronze5;

import java.util.Scanner;

public class Bronze5_25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String result = "";

        if (N % 4 == 0) {
            for (int i = 0; i < N/4; i++) {
                result += "long ";
            }
        }

        System.out.println(result + "int");
    }
}
