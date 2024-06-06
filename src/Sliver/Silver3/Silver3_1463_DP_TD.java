package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_1463_DP_TD {

    public static int dp(int num, int count) {
        if (num < 2) {
            return count;
        }

        return Math.min(dp(num / 2, count + 1 + (num % 2)), dp(num / 3, count + 1 + (num % 3)));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(dp(N, 0));
    }
}
