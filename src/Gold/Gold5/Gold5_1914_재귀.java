package Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Gold5_1914_재귀 {
    static StringBuilder sb = new StringBuilder();

    public static void recursive(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        recursive(N - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        recursive(N - 1, mid, start, to);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("2");
        sb.append(num.pow(N).subtract(new BigInteger("1"))).append("\n");
        if (N <= 20) {
            recursive(N, 1, 2, 3);
        }
        System.out.println(sb);
    }
}
