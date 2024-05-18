package Sliver.Silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_1260_그래프 {

    static int N, M, V;     // 노드, 간선, 시작 노드
    static boolean[] visited;       // 방문을 체크할 배열
    static boolean[][] graph;       // 그래프의 정보를 담을 2차원 배열
    static ArrayList<Integer> queue;    // BFS에서 사용할 queue


    public static void dfs(int start) {
        System.out.print(start + " ");      // 방문한 노드의 정보를 출력
        visited[start] = true;      // 해당 노드를 방문 체크

        for (int i = 1; i <= N; i++) {      // 총 노드의 개수만큼 반복
            if (!visited[i] && graph[start][i]) {       // i번째의 노드가 아직 방문하지 않았고, 그래프에서 start 노드와 연결되어 있다면 dfs를 진행
                dfs(i);
            }
        }
    }

    public static void bfs() {
        queue = new ArrayList<>();          // bfs를 진행할 queue 자료구조를 생성
        visited = new boolean[N + 1];       // bfs에서 사용할 방문 배열을 새로 생성

        queue.add(V);       // 시작 노드인 V를 queue에 추가
        visited[V] = true;  // 해당 노드를 방문 체크

        while (!queue.isEmpty()) {      // queue에 데이터가 없을때까지(즉, 탐색이 다 끝날 경우)
            int index = queue.remove(0);        // queue에 가장 맨 앞에 있는 데이터를 index로 추출
            System.out.print(index + " ");            // 방문한 노드의 정보를 출력
            for (int i = 1; i <= N; i++) {      // 총 노드의 개수만큼 반복
                if (!visited[i]&& graph[index][i]) {       // i번째 해당하는 노드가 아직 방문하지 않았고, 그래프에서 start 노드와 연결되어 있다면 탐색을 진행 
                    visited[i] = true;      // i번째 해당하는 노드를 방문 체크
                    queue.add(i);           // i번째 노드를 queue에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 총 노드의 개수
        M = Integer.parseInt(st.nextToken());       // 총 간선의 개수
        V = Integer.parseInt(st.nextToken());       // 시작 노드의 정보

        graph = new boolean[N+1][N+1];      // 1부터 시작하기 위해서 그래프의 행과 열을 1증가시켜 초기화
        
        visited = new boolean[N + 1];       // 1부터 시작하기 위해서 방문 배열을 1 증가시켜서 초기화

        for (int i = 0; i < M; i++) {       // 총 간선의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;     // 간선으로 연결된 노드에 true를 저장
            graph[y][x] = true;     // 간선으로 연결된 노드에 true를 저장
        }

        dfs(V);     // 시작 노드인 V를 기점으로 dfs 시작
        System.out.println();
        bfs();      // bfs는 재귀를 하지 않기 때문에 매개변수 없이 시작

    }
}
