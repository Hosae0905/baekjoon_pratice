package Bronze.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze3_10988_심화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            char first = str.charAt(i);
            char last = str.charAt((length - 1) - i);

            if (first != last) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
