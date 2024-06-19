import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void preOrder(int start) {
        if (start == -1) return;

        sb.append((char) (start + 'A'));
        preOrder(graph[start][0]);
        preOrder(graph[start][1]);
    }

    public static void inOrder(int start) {
        if (start == -1) return;

        inOrder(graph[start][0]);
        sb.append((char) (start + 'A'));
        inOrder(graph[start][1]);
    }

    public static void postOrder(int start) {
        if (start == -1) return;

        postOrder(graph[start][0]);
        postOrder(graph[start][1]);
        sb.append((char) (start + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph  = new int[26][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            if (left == -19) {
                graph[parent][0] = -1;
            } else {
                graph[parent][0] = left;
            }

            if (right == -19) {
                graph[parent][1] = -1;
            } else {
                graph[parent][1] = right;
            }
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);



        System.out.println(sb);
    }
}
