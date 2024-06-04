import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] arr = new long[101];

    static long pado(int num) {
        if (arr[num] != -1) {
            return arr[num];
        } else {
            return arr[num] = pado(num - 2) + pado(num - 3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(pado(num)).append("\n");
        }

        System.out.println(sb);
    }
}
