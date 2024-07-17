import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 산술평균: N개의 수들의 합을 N으로 나눈 값
 * 중앙값: N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값: N개의 수들 중 가장 많이 나타나는 값
 * 범위: N개의 수들 중 최댓값과 최솟값의 차이
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[8001];


        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid = 10000;
        int mode = 10000;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            if (max < value) {
                max = value;
            }

            if (min > value) {
                min = value;
            }
        }

        int count = 0;
        int mode_max = 0;

        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                if (count < (N + 1) / 2) {
                    count += arr[i];
                    mid = i - 4000;
                }

                if (mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if (mode_max == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        sb.append((int)Math.round((double) sum / N)).append("\n");     // 산술 평균
        sb.append(mid).append("\n");      // 중앙 값
        sb.append(mode).append("\n");
        sb.append(max - min);       // 범위
        System.out.println(sb);
    }
}
