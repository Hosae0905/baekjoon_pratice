package Bronze.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_25501_재귀 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int result = isPalindrom(str[i]);

            sb.append(result).append(" ").append(count).append("\n");
            count = 0;
        }

        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrom(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
