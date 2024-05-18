package Sliver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Silver2_4963_DFS {

    final static int MAX = 50 + 10;     // map의 크기가 최대 50
    static int N, M;        // 너비와 높이(너비: 행, 높이: 열)
    static boolean[][] map;     // 섬과 바다의 정보를 담을 2차원 배열
    static boolean[][] visited; // 방문을 체크할 2차원 배열

    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};        // 상하좌우 + 대각선 위치의 Y 좌표
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};        // 상하좌우 + 대각선 위치의 X 좌표

    public static void dfs(int y, int x) {
        visited[y][x] = true;       // y, x 좌표에 해당하는 노드를 방문 체크
        for (int i = 0; i < 8; i++) {       // 상하좌우 + 대각선이기 때문에 총 8방향을 검사
            int newY = y + dirY[i];     // 각 방향마다 y값을 더하여 새로운 y 좌표 생성
            int newX = x + dirX[i];     // 각 방향마다 x값을 더하여 새로운 x 좌표 생성
            if (map[newY][newX] && !visited[newY][newX]) {      // 새로운 y좌표와 x좌표에 해당하는 곳이 true(땅)이고, 아직 방문하지 않았다면 dfs 진행
                dfs(newY, newX);        // 새로운 y좌표와 x좌표로 dfs 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {      // 입력의 마지막 줄에 0이 주어지기 때문에 그 전까지 무한 반복
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());   // 너비(행)
            N = Integer.parseInt(st.nextToken());   // 높이(열)

            if (N == 0 && M == 0) {     // 0이 주어지면 마지막이라는 의미로 반복문을 종료
                break;
            }

            map = new boolean[MAX][MAX];        // MAX 값으로 맵을 초기화
            visited = new boolean[MAX][MAX];    // MAX 값으로 방문 배열을 초기화

            for (int i = 1; i <= N; i++) {      // 높이(열) N 만큼 반복
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {  // 너비(행) M 만큼 반복
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;  // 1은 땅을 의미하기 때문에 여기서는 true
                }
            }
            int answer = 0;     // 정답 변수 초기화
            for (int i = 1; i <= N; i++) {      // 높이(열) N 만큼 반복
                for (int j = 1; j <= M; j++) {  // 너비(행) M 만큼 반복
                    if (map[i][j] && !visited[i][j]) {      // i, j 위치가 1(땅)이고, 아직 방문하지 않았다면 dfs 진행
                        dfs(i, j);      // i, j를 좌표로 삼아서 dfs 진행
                        answer++;       // dfs를 진행하여 연결된 값끼리는 하나의 땅으로 간주
                    }
                }
            }

            bw.write(String.valueOf(answer));       // 정답을 출력
            bw.newLine();

        }

        bw.close();
        br.close();
    }
}
