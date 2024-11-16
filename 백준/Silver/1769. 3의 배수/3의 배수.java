import java.io.*;
import java.util.*;

/**
 * 백준 1769번
 */
public class Main {

    static int count = 0;
    static String str = "";


    static void sum() {
        int num = 0;

        if (str.length() == 1) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i) - '0';
        }

        count++;
        str = String.valueOf(num);
        sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        StringBuilder sb = new StringBuilder();

        sum();
        sb.append(count).append("\n");
        if (Integer.parseInt(str) % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb.toString());
    }
}
