package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1182_수학 {

    static int N, M, count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (M == 0) count--; // 공집합 제외
        System.out.println(count);
    }

    public static void dfs(int start, int sum) {
        if (start == N) {
            if (sum == M) {
                count++;
            }
            return;
        }

        dfs(start + 1, sum + arr[start]);
        dfs(start + 1, sum);
    }
}
