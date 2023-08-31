package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_1748_구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;      // 자릿수
        int num = 1;        // 현재 자릿수
        int criteria = 10;  // 10의 자릿수
        for (int i = 1; i <= N; i++) {
            if (i % criteria == 0) {        // 10의 자릿수가 넘어가는지 확인
                num += 1;                   // 10의 자릿수는 2이기 때문에 기존 1의 자릿수 값인 1을 2로 변경
                criteria *= 10;             // 10의 자릿수가 넘어가면 100의 자릿수로 변경
            }
            count += num;
        }
        System.out.println(count);
    }
}
