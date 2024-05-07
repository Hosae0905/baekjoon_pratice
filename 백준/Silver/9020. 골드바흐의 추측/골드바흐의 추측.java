import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        ArrayList<Integer> list;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int X : arr) {
            int[] prime = new int[X + 1];
            list = new ArrayList<>();
            int min = X / 2;
            int max = X / 2;

            for (int i = 1; i < prime.length; i++) {
                prime[i] = i;
            }

            for (int i = 0; i < prime.length; i++) {
                if (prime[i] == 0) continue;
                if (prime[i] == 1) {
                    prime[i] = 0;
                    continue;
                }
                for (int j = i * 2; j < prime.length; j+=i) {
                    prime[j] = 0;
                }
            }

            for (int i = 0; i < prime.length; i++) {
                if (prime[i] != 0) {
                    list.add(prime[i]);
                }
            }

            while (true) {
                if (list.contains(min) && list.contains(max)) {
                    sb.append(min).append(" ").append(max).append("\n");
                    break;
                }
                min--;
                max++;
            }
        }
        System.out.println(sb);
    }
}
