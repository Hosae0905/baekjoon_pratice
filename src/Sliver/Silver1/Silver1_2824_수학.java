package Sliver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Silver1_2824_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger("1");
        BigInteger B = new BigInteger("1");

        for (int i = 0; i < N; i++) {
            A = A.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B = B.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }

        BigInteger result = gcp(A, B);

        if (result.toString().length() > 9) {
            System.out.println(result.toString().substring(result.toString().length() - 9));
        } else {
            System.out.println(result);
        }
    }

    public static BigInteger gcp(BigInteger a, BigInteger b) {
        if (b.signum() == 0) return a;
        return gcp(b, a.remainder(b));
    }
}
