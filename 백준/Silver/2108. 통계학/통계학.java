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
        int total = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            total += value;
        }

        Arrays.sort(arr);

        boolean flag = false;
        int max = 0;
        int mode = 10000;

        for (int i = 0; i < N; i++) {
            int jump = 0;
            int count = 1;
            int value = arr[i];

            for (int j = i + 1; j < N; j++) {
                if (value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if (count > max) {
                max = count;
                mode = value;
                flag = true;
            } else if (count == max && flag == true) {
                mode = value;
                flag = false;
            }

            i += jump;
        }


        sb.append((int)Math.round((double) total / N)).append("\n");     // 산술 평균
        sb.append(arr[N / 2]).append("\n");      // 중앙 값
        sb.append(mode).append("\n");
        sb.append(arr[N - 1] - arr[0]);       // 범위
        System.out.println(sb);
    }
}
