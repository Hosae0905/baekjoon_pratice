import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] prime = new int[1000001];
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makePrime();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j <= arr[i] / 2; j++) {
                if (prime[j] != 0 && prime[arr[i] - j] != 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
            count = 0;
        }


        System.out.println(sb);
    }

    public static void makePrime() {
        for (int i = 1; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 0; i < Math.sqrt(prime.length); i++) {
            if (prime[i] == 0) continue;
            if (prime[i] == 1) {
                prime[i] = 0;
                continue;
            }
            for (int j = i * 2; j < prime.length; j+=i) {
                prime[j] = 0;
            }
        }
    }
}
