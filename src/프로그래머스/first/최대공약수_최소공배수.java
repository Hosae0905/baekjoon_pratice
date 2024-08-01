package 프로그래머스.first;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 최대공약수_최소공배수 {

    public static int[] test(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;

        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }

    public static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }

    public static void main(String[] args) {
        int[] result = test(3, 12);
        System.out.println(Arrays.toString(result));
    }
}
