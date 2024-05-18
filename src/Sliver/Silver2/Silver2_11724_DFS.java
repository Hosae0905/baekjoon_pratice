package Sliver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Silver2_11724_DFS {

    static int N, M;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 노드의 개수
        M = Integer.parseInt(st.nextToken());       // 간선의 개수

        visited = new boolean[N + 1];       // 1부터 시작하기 위해 +1을 하여 방문 배열을 초기화
        graph = new boolean[N + 1][N + 1];  // 1부터 시작하기 위해 +1을 하여 dfs 그래프 초기화

        for (int i = 0; i < M; i++) {       // 연결된 간선의 수만큼 반복
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;     // 서로 연결되어 있는 노드를 true로 변경
            graph[y][x] = true;     // 서로 연결되어 있는 노드를 true로 변경
        }

        for (int i = 1; i <= N; i++) {      // 1번부터 시작하여 연결요소를 찾기
            if (!visited[i]) {      // i번를 아직 방문하지 않았을 경우 dfs 실행
                dfs(i);
                answer++;       // i번 노드의 연결 요소를 다 체크했으면 정답을 1 증가
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    public static void dfs(int start) {
        visited[start] = true;      // 출발 지점을 방문 처리
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[start][i]) {   // i번째 해당하는 인덱스가 아직 방문하지 않았고, dfs 그래프의 start 노드와 연결되어 있으면 dfs 실행
                dfs(i);
            }
        }
    }
}
