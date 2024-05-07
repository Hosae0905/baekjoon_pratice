package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver2_4948_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = 1;
        int[] arr;

        while(N != 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int count = 0;

            arr = new int[N * 2 + 1];

            for (int i = 1; i < arr.length; i++) {
                arr[i] = i;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                if (arr[i] == 1) {
                    arr[i] = 0;
                    continue;
                }
                for (int j = i * 2; j < arr.length; j+=i) {
                    if (j > arr.length) {
                        break;
                    }
                    arr[j] = 0;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 0 && arr[i] > N && arr[i] <= arr.length) {
                    count++;
                }
            }
            if (N != 0) sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
