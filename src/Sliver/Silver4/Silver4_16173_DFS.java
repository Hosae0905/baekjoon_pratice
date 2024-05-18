package Sliver.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class Silver4_16173_DFS {
    static int N;       // 게임 구역의 크기
    static int[][] map;     // 게임 구역을 저장할 2차원 배열
    static boolean[][] visited;     // 방문을 체크할 2차원 배열
    static int[] dirY = {1, 0};     // 가로, 세로의 y 좌표를 구할 배열
    static int[] dirX = {0, 1};     // 가로, 세로의 x 좌표를 구할 배열
    final static int MAX = 3 + 110;     // 최대 게임 구역의 크기는 3, 칸에는 최대 100까지 들어올 수 있음, 여분으로 10을 추가 그래서 3 + 110
                                        // 만약 특정 칸에 100이 들어온다면 100칸을 움직일 수 있으므로 MAX 사이즈를 100 더해줘야 한다.

    public static void dfs(int y, int x) {
        visited[y][x] = true;       // y, x 좌표에 해당하는 노드를 방문 체크

        if (y == N && x == N) {     // 만약 최종 목적지에 도달했다면 dfs를 종료
            return;
        }

        for (int i = 0; i < 2; i++) {       // 가로, 세로 총 2방향으로 인접한 노드를 탐색
            int newY = y + dirY[i] * map[y][x];     // 해당 칸의 정수 값 만큼 이동을 해야되기 때문에 map[y][x]에 해당하는 값 만큼 곱해서 기존의 y값과 더하기
            int newX = x + dirX[i] * map[y][x];     // 해당 칸의 정수 값 만큼 이동을 해야되기 때문에 map[y][x]에 해당하는 값 만큼 곱해서 기존의 x값과 더하기

            if (!visited[newY][newX]) {     // 새로운 y, x 값을 아직 방문하지 않았다면 dfs를 진행
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력과 초기화를 진행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());        // 게임 구역의 크기

        map = new int[MAX][MAX];            // MAX 사이즈만큼 map을 생성
        visited = new boolean[MAX][MAX];    // MAX 사이즈만큼 방문 배열을 생성

        // 1. map에 게임 구역의 데이터를 저장
        for (int i = 1; i <= N; i++) {      // 세로(열) N 만큼 반복
            st = new StringTokenizer(br.readLine());    // 칸에 들어갈 정수값 받기
            for (int j = 1; j <= N; j++) {  // 가로(행) N 만큼 반복
                map[i][j] = Integer.parseInt(st.nextToken());   // 칸에 정수값 저장
            }
        }

        // 2. dfs 진행
        dfs(1, 1);

        // 3. 결과 값을 출력
        if (visited[N][N]) {        // N, N 좌표를 방문했다는 것은 게임의 최종 목적지에 도달했다고 판단하고 정답을 출력
            bw.write("HaruHaru");
        } else {                    // 도달하지 못했다면 실패를 출력
            bw.write("Hing");
        }

        bw.close();
        br.close();
    }
}
