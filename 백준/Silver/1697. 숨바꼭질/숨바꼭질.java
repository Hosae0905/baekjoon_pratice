import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1000000 + 10;
    static int N, K;
    static int[] visited;

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int value = queue.remove();

            if (value == K) {
                return visited[value] - 1;
            }

            if (value - 1 >= 0 && visited[value - 1] == 0) {
                visited[value - 1] = visited[value] + 1;
                queue.add(value - 1);

            }

            if (value + 1 <= 100000 && visited[value + 1] == 0) {
                visited[value + 1] = visited[value] + 1;
                queue.add(value + 1);
            }

            if (2 * value <= 100000 && visited[2 * value] == 0) {
                visited[2 * value] = visited[value] + 1;
                queue.add(2 * value);
            }
        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[MAX];
        int result = bfs(N);

        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
