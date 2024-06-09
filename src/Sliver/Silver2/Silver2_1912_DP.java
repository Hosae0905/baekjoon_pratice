package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1912_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            list[i] = Math.max(list[i - 1] + arr[i], arr[i]);
            max = Math.max(max, list[i]);
        }
        System.out.println(max);

    }
}
