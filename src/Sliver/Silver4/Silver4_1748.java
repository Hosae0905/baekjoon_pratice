package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 1;
        int criteria = 10;
        for (int i = 1; i <= N; i++) {
            if (i % criteria == 0) {
                num += 1;
                criteria *= 10;
            }
            count += num;
        }
        System.out.println(count);
    }
}
