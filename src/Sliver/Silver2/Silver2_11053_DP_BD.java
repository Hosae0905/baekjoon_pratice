package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_11053_DP_BD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] list = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            list[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && list[i] < list[j] + 1) {
                    list[i] = list[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(list[i], max);
        }

        System.out.println(max);
    }
}
