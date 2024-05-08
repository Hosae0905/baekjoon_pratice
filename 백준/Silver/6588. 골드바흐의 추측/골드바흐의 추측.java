import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] prime = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        getPrime();

        while (true) {
            int X = Integer.parseInt(br.readLine());
            if (X == 0) {
                break;
            }

            int min = 0;
            int max = X;


            while (min < X) {
                if (prime[min] != 0 && prime[max] != 0 && min + max == X) {
                    sb.append(X).append(" = ").append(min).append(" + ").append(max).append("\n");
                    break;
                }
                min++;
                max--;
            }

            if (min + max != X) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void getPrime() {
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
