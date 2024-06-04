import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr = new int[41][2];

    public static int[] fibo(int num) {
        if (arr[num][0] == -1 || arr[num][1] == -1) {

            arr[num][0] = fibo(num - 1)[0] + fibo(num - 2)[0];
            arr[num][1] = fibo(num - 1)[1] + fibo(num - 2)[1];
        }

        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            sb.append(arr[num][0]).append(" ").append(arr[num][1]).append("\n");
        }

        System.out.println(sb);

    }
}
