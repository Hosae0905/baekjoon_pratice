package Sliver.Silver2;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver2_2644_DFS {
    final static int MAX = 100 + 10;        // 최대값에 +10을 하여 예상치 못한 예외를 처리
    static boolean[] visited;               // 방문 배열
    static int N, M, start, end;        // N = 총 사람(노드)의 수, M = 부모 자신간의 관계(간선)의 수, 
                                        // start = 촌수를 계산할 사람(시작 노드), end = 촌수를 계산할 사람(종료 노드)
    static boolean[][] graph;       // 그래프 정보를 담을 2차원 배열
    static int answer;      // 정답을 출력할 변수

    public static void dfs(int index, int count) {
        visited[index] = true;      // 해당 index를 방문 체크
        if (index == end) {         // index와 end가 같다면 목적지까지 도착했다고 판단
            answer = count;         // 정답 변수인 answer에 이때까지 촌수를 구했던 count를 저장
            return;     // dfs를 종료
        }

        for (int i = 1; i <= N; i++) {      // 총 노드만큼 반복
            if (!visited[i] && graph[index][i]) {   // 아직 방문하지 않았고, index 노드와 연결된 노드라면 dfs를 진행
                dfs(i, count + 1);      // dfs를 진행할때 count를 증가시켜서 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());        // 총 사람의 수(노드)
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());   // 시작 노드
        end = Integer.parseInt(st.nextToken());     // 종료 노드
        M = Integer.parseInt(br.readLine());        // 부모 자식 관계(간선)

        graph = new boolean[MAX][MAX];      // MAX 만큼 그래프를 생성
        visited = new boolean[MAX];         // MAX 만큼 방문 배열을 생성
        answer = -1;                        // 촌수가 없을 때(연결 요소가 없을 떄) 값을 출력하기 위해 -1로 저장

        for (int i = 0; i < M; i++) {       // 총 간선의 수 만큼 반복
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;     // 서로 간선으로 연결된 노드에 true를 저장
            graph[y][x] = true;     // 서로 간선으로 연결된 노드에 true를 저장
        }

        dfs(start, 0);      // 촌수를 구할 시작 노드부터 촌수를 계산할 count를 매개변수로 dfs를 진행

        bw.write(String.valueOf(answer));       // 정답 출력
        bw.close();
        br.close();
    }
}
