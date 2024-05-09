package Gold.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gold4_2981_수학 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int R;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == N && arr[start] % R == arr[depth - 1] % R) {
            sb.append(R).append(" ");
            return;
        }

        for (int i = 2; i <= arr[start]; i++) {
            if (arr[start] % i == arr[depth] % i) {
                R = i;
                dfs(start, depth + 1);
            }
            if (i == arr[start]) {
                return;
            }
        }
    }
}
