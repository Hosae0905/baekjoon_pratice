import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 50 + 10;
    static char[][] map;
    static int N, M;

    public static void dfs(int y, int x) {
        char cur = map[y][x];
        map[y][x] = 0;

        if (cur == '-' && map[y][x + 1] == '-') {
            dfs(y, x + 1);
        }

        if (cur == '|' && map[y + 1][x] == '|') {
            dfs(y + 1, x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
