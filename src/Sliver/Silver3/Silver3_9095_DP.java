package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_9095_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[11];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append("\n");
        }

        System.out.println(sb);
    }
}