package Sliver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver5_1181_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] M = new String[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M[i] = st.nextToken();
        }

        Arrays.sort(M, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else return o1.length() - o2.length();
            }
        });

        System.out.println(M[0]);
        for (int i = 1; i < M.length; i++) {
            if (!M[i].equals(M[i-1])) {
                System.out.println(M[i]);
            }
        }
    }
}
