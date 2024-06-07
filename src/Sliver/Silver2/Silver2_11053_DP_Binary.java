package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_11053_DP_Binary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] list = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list[0] = arr[0];
        int index = 1;

        for (int i = 1; i < N; i++) {
            if (list[index - 1] < arr[i]) {
                list[index++] = arr[i];
            } else if (list[0] > arr[i]) {
                list[0] = arr[i];
            } else {
                int temp = Arrays.binarySearch(list, 0, index, arr[i]);
                list[temp < 0 ? -(temp + 1) : temp] = arr[i];
            }
        }

        System.out.println(index);
    }
}
