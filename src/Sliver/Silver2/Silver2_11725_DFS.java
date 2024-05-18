package Sliver.Silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver2_11725_DFS {

    static int N, M;        // 노드, 간선
    static ArrayList<Integer>[] graph;      // 주어진 최대값이 10만이라서 인접 리스트로 구현
    static boolean[] visited;       // 방문을 체크할 방문 배열
    static int[] answer;        // 정답을 담을 배열

    public static void dfs(int start) {
        visited[start] = true;      // start 노드를 방문 체크

        for (int i = 0; i < graph[start].size(); i++) {     // start 노드의 인접 리스트의 size 만큼 반복
            if (!visited[graph[start].get(i)]) {        // start 노드의 인접 리스트에서 i번째 노드부터 방문을 확인
                answer[graph[start].get(i)] = start;    // 만약 graph[start].get(i) 값이 4라고 하면 4번 노드의 부모는 2가 된다.
                                                        // 따라서 정답 배열에서 4번 위치에 부모 노드의 정보인 start를 대입
                dfs(graph[start].get(i));       // start 노드에서 i번째 노드를 기준으로 다시 dfs를 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());        // 노드의 총 개수
        M = N - 1;          // 간선은 항상 노드의 총 개수 - 1
        graph = new ArrayList[N + 1];       // N + 1 만큼 리스트를 초기화
        visited = new boolean[N + 1];       // N + 1 크기로 방문 배열을 초기화
        answer = new int[N + 1];            // N + 1 크기로 정답 배열을 초기화

        for (int i = 1; i <= N; i++) {      // N + 1 크기만큼 인접 리스트를 생성했기 때문에 1부터 시작
            graph[i] = new ArrayList<>();       // i번째 해당하는 그래프에 ArrayList 생성
        }

        for (int i = 0; i < M; i++) {       // 총 간선의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);        // x노드에 y값 추가
            graph[y].add(x);        // y노드에 x값 추가
        }

        dfs(1);     // 트리의 루트는 1이라고 가정했기 때문에 1부터 시작

        for (int i = 2; i <= N; i++) {      // 2번 노드부터 순서대로 출력하라고 해서 i는 2부터 시작
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
