package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_2798_브루트포스 {
    public static void main(String[] args) {
        // 5 21
        // 5 6 7 8 9
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();        // 카드의 개수 --> 5
        int M = sc.nextInt();        // 최댓값 --> 21
        int[] arr = new int[N];
        int sum = 0;
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();      // --> 5 6 7 8 9
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if(tmp < sum && sum <= M)
                        tmp = sum;
                }
            }
        }

        System.out.println(tmp);
    }
}
