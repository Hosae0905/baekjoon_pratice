package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2606_DFS {

    static int computer = 0;    // 감염된 컴퓨터의 수
    static boolean[] visited;   // 방문을 체크할 배열
    static boolean[][] arr;     // DFS를 그려줄 그래프
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());        // 컴퓨터의 수(노드)
        M = Integer.parseInt(br.readLine());        // 컴퓨터 쌍의 수(간선)
        visited = new boolean[N + 1];               // 컴퓨터의 수보다 많이 설정
        arr = new boolean[N + 1][N + 1];            // 컴퓨터의 수보다 많이 설정

        for (int i = 0; i < M; i++) {          // 연결된 컴퓨터의 쌍을 dfs 그래프로 표현
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;       // 연결된 노드
            arr[y][x] = true;       // 연결된 노드
        }

        dfs(1);     // 1번 컴퓨터가 바이러스에 걸린 예시를 들어서 1번 노드부터 출발

        System.out.println(computer - 1);       // 감염된 자기 자신은 제외하고 출력

        br.close();
    }

    public static void dfs(int start) {
        visited[start] = true;      // 출발 지점이 되는 노드를 방문 처리
        computer++;         // 바이러스에 감염된 노드와 연결되어 있다고 판단하고 감염된 컴퓨터 숫자를 증가

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[start][i]) {     // 아직 방문을 하지 않았고, i번째 해당하는 숫자가 start 노드와 연결되어 있다면 dfs를 진행
                dfs(i);
            }
        }
    }
}
