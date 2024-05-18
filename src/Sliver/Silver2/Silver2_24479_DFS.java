package Sliver.Silver2;

import java.io.*;
import java.util.*;

public class Silver2_24479_DFS {

    static int N, M, R;     // 노드, 간선, 시작 노드
    static boolean[] visited;       // 방문 배열
    static ArrayList<Integer>[] graph;      // dfs 그래프를 표현할 인접 리스트
    static int[] answer;        // 정답을 담을 배열
    static int order;       // 방문 순서를 체크할 임시 값


    public static void dfs(int start) {
        visited[start] = true;      // start 노드를 방문 체크
        answer[start] = order;      // 정답 배열에 시작 노드를 인덱스로 하는 위치에 order 데이터를 추가
        order++;        // 위에서 방문한 정보를 정답 배열에 추가했기 때문에 order를 1 증가

        for (int i = 0; i < graph[start].size(); i++) {     // dfs 그래프에서 start 노드에 위치한 인접 리스트의 size 만큼 반복
                                                            // (이때는 인접 리스트를 생성할때 따로 사이즈를 주지 않았기 때문에 0부터 시작해야함.)
            int value = graph[start].get(i);    // dfs 그래프에서 start 노드에 위치한 인접 리스트에서 i번째 해당하는 값부터 확인하기
            if (!visited[value]) {      // 해당 value 값이 아직 방문하지 않았다면 value를 시작 노드로 dfs를 진행
                dfs(value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 총 노드의 개수를 받기
        M = Integer.parseInt(st.nextToken());       // 총 간선의 개수를 받기
        R = Integer.parseInt(st.nextToken());       // 시작 노드의 정보를 받기

        visited = new boolean[N + 1];       // 1부터 시작하기 위해서 총 노드의 개수보다 1 증가시켜서 초기화
        graph = new ArrayList[N + 1];       // 1부터 시작하기 위해서 총 노드의 개수보다 1 증가시켜서 초기화
        answer = new int[N + 1];            // 노드의 순서는 1부터 시작하기 때문에 1 증가시켜 초기화
        order = 1;      // 노드의 순서는 1부터 시작하기 때문에 1로 초기화

        for (int i = 1; i <= N; i++) {      // 총 노드의 수만큼 dfs 그래프를 초기화
            graph[i] = new ArrayList<>();   // ArrayList의 배열이기 때문에 ArrayList를 담는 배열에서 i번째에 해당하는 곳에 초기화가 필요
        }

        for (int i = 0; i < M; i++) {       // 총 간선의 개수만큼 반복을 돌면서 dfs 그래프에 데이터 삽입
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);        // 배열의 x인덱스에 위치한 ArrayList에 y값을 삽입
            graph[y].add(x);        // 배열의 y인덱스에 위치한 ArrayList에 x값을 삽입
        }

        for (int i = 1; i <= N; i++) {      // 총 노드의 개수만큼 반복
            Collections.sort(graph[i]);     // dfs 그래프의 i번째 인덱스에 해당하는 ArrayList를 오름차순으로 정렬
        }

        dfs(R);     // 시작 노드인 R부터 dfs를 시작

        for (int i = 1; i <= N; i++) {      // 총 노드의 개수인 N까지 반복, 1번째 노드부터 시작하니 i는 1부터 시작
            bw.write(String.valueOf(answer[i]));    // 정답 배열의 i번째를 출력
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
