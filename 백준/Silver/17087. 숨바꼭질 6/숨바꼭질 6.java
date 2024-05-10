import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int value = arr[0];

        for (int i = 1; i < arr.length; i++) {
            value = gcp(value, arr[i]);
        }

        System.out.println(value);
    }

    public static int gcp(int a, int b) {
        if (b == 0) return a;
        return gcp(b, a % b);
    }
}
