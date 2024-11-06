import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[][] M = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M[i][0] = st.nextToken();
            M[i][1] = st.nextToken();
        }

        Arrays.sort(M, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0] == o2[0]) return 1;
                else {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for (int i = 0; i < M.length; i++) {
            sb.append(M[i][0]).append(" ").append(M[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}