package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Silver2_9020_수학_개선 {

    static int[] prime = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        ArrayList<Integer> list;

        isPrime();

        while (N-- > 0) {
            int X = Integer.parseInt(br.readLine());
            int min = X / 2;
            int max = X / 2;

            while (true) {
                if (prime[min] != 0 && prime[max] != 0) {
                    sb.append(min).append(" ").append(max).append("\n");
                    break;
                }
                min--;
                max++;
            }
        }

        System.out.println(sb);
    }

    public static void isPrime() {
        for (int i = 1; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 0; i < Math.sqrt(prime.length); i++) {
            if (prime[i] == 0) continue;
            if (prime[i] == 1) {
                prime[i] = 0;
                continue;
            }
            for (int j = i * 2; j < prime.length; j+=i) {
                prime[j] = 0;
            }
        }
    }
}
