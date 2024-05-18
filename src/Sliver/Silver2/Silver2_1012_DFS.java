package Sliver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Silver2_1012_DFS {
    final static int MAX = 50 + 10;     // 배추밭의 가로 및 세로 길이의 최대값 + 10
    static boolean[][] map;             // 배추밭의 정보를 담을 맵
    static boolean[][] visited;         // 방문을 체그할 2차원 배열
    static int T, N, M, K;              // T = 테스트 케이스, N = 세로 길이, M = 가로 길이, K = 배추가 심어져있는 위치
    static int[] dirY = {1, -1, 0, 0};  // y좌표 값
    static int[] dirX = {0, 0, 1, -1};  // x좌표 값

    public static void dfs(int y, int x) {
        visited[y][x] = true;       // y, x위치에 방문 체크
        for (int i = 0; i < 4; i++) {       // 상하좌우(4방향)만큼 반복
            int newY = y + dirY[i];     // y 값에 상하좌우 값을 더하여 새로운 y값을 생성
            int newX = x + dirX[i];     // x 값에 상하좌우 값을 더하여 새로운 x값을 생성

            if (map[newY][newX] && !visited[newY][newX]) {      // 새로운 y,x 위치에 배추가 심어져 있고, 아직 방문하지 않았다면 해당 좌표 값으로 dfs를 진행
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());     // 테스트 케이스

        while (T-- > 0) {       // 테스트 케이스가 끝날때까지
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 가로 길이
            N = Integer.parseInt(st.nextToken());       // 세로 길이
            K = Integer.parseInt(st.nextToken());       // 배추가 심어진 위치

            map = new boolean[MAX][MAX];        // MAX 만큼 맵을 초기화
            visited = new boolean[MAX][MAX];    // MAX 만큼 방문 배열을 초기화

            for (int i = 0; i < K; i++) {       // 배추가 심어진 위치의 개수만큼 반복
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());       // 배추가 심어진 위치의 x 값
                int y = Integer.parseInt(st.nextToken());       // 배추가 심어진 위치의 y 값

                map[y + 1][x + 1] = true;       // 1부터 시작하기 위헤서 y, x의 값을 + 1한 값에 true를 저장
            }

            int answer = 0;     // 정답을 0으로 초기화
            for (int i = 1; i <= N; i++) {      // 세로(열)의 길이만큼 반복
                for (int j = 1; j <= M; j++) {  // 가로(행)의 길이만큼 반복
                    if (map[i][j] && !visited[i][j]) {  // i, j 위치에 배추가 심어져있고, 해당 위치를 아직 방문하지 않았다면 i,j로 dfs를 진행
                        dfs(i, j);
                        answer++;       // 정답을 1 증가
                    }
                }
            }
            bw.write(String.valueOf(answer));   // 정답 출력
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
