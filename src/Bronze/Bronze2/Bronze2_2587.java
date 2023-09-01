package Bronze.Bronze2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bronze2_2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[5];
        int sum = 0;

        for (int i = 0; i < N.length; i++) {
            N[i] = sc.nextInt();
        }

        for (int i = 0; i < N.length-1; i++) {
            for (int j = 0; j < N.length-1; j++) {
                if (N[j] > N[j+1]) {
                    int temp;
                    temp = N[j];
                    N[j] = N[j + 1];
                    N[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i< N.length; i++) {
            sum += N[i];
        }

        System.out.println(sum / N.length);
        System.out.println(N[N.length / 2]);

    }
}
