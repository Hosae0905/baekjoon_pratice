package Sliver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_1436_브루트포스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int number = 666;
        int count = 1;

        while (count != n) {
            number++;
            if (String.valueOf(number).contains("666")) {
                count++;
            }
        }

        System.out.println(number);
    }
}
