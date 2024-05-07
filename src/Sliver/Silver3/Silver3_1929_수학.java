package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_1929_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (arr[i] == 1) {
                arr[i] = 0;
                continue;
            }
            for (int j = i * 2; j < arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        for (int i = N; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
