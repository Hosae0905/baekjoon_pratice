package Bronze.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze3_3009_네번째점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");
        String[] third = br.readLine().split(" ");

        String x;
        String y;

        if (first[0].equals(second[0])) {
            x = third[0];
        } else if (first[0].equals(third[0])) {
            x = second[0];
        } else {
            x = first[0];
        }

        if (first[1].equals(second[1])) {
            y = third[1];
        } else if (first[1].equals(third[1])) {
            y = second[1];
        } else {
            y = first[1];
        }

        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}
