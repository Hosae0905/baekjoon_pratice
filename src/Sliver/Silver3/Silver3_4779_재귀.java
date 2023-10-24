package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Silver3_4779_재귀 {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int test = N * 3;
        String str = "";

        for (int i = 0; i < test; i++) {
            str += "-";
        }

        recursive(str, test);

        System.out.println(sb);
    }

    public static String recursive(String str, int n) {
        if (str.length() == 0) return "-";
        else {
            int sub = n / 3;
            return recursive(str.substring(sub, sub * 2), sub);
        }
    }*/

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            int len = (int) Math.pow(3, n);

            sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            recursive(0, len);
            System.out.println(sb);
        }
    }

    private static void recursive(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        recursive(start, newSize);
        recursive(start + 2 * newSize, newSize);
    }
}
