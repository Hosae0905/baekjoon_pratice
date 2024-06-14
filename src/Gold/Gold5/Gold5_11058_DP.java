package Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold5_11058_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i > 6) {
                for (int j = 2; j < 5; j++) {
                    arr[i] = Math.max(arr[i], arr[i - (j + 1)] * j);
                }
            }
        }

        System.out.println(arr[N]);
    }
}
