package Sliver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class Silver2_13565_DFS {
    final static int MAX = 1000 + 10;       // 격자의 최대값이 1000
    static boolean[][] map;         // 격자의 정보를 담을 2차원 맵
    static boolean[][] visited;     // 방문을 체크할 2차원 배열
    static int[] dirY = {-1, 1, 0, 0};  // y좌표의 상하좌우를 계산할 배열
    static int[] dirX = {0, 0, -1, 1};  // x좌표의 상하좌우를 게산할 배열
    static int N, M;    // N(행, 가로), M(열, 세로)
    static boolean answer;      // 정답이 true 혹은 false

    public static void dfs(int y, int x) {
        if (y == M) {       // y가 M이랑 같다면 전류가 잘 통한다고 판단
            answer = true;  // answer에 true를 저장
            return;         // 전류가 잘 통하는걸 확인했기 때문에 dfs를 종료
        }

        visited[y][x] = true;   // y,x 위치를 방문 체크
        
        for (int i = 0; i < 4; i++) {       // 상하좌우만큼 반복
            int newY = y + dirY[i];     // 새로운 y 좌표 생성
            int newX = x + dirX[i];     // 새로운 x 좌표 생성

            if (map[newY][newX] && !visited[newY][newX]) {  // 새로운 y, x 좌표가 true이면서, 아직 방문하지 않았다면 해당 좌표로 dfs를 진행
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());       // 격자의 세로 크기
        N = Integer.parseInt(st.nextToken());       // 격자의 가로 크기

        map = new boolean[MAX][MAX];        // MAX 크기만큼 map을 초기화
        visited = new boolean[MAX][MAX];    // MAX 크기만큼 방문 배열을 초기화

        for (int i = 1; i <= M; i++) {
            String str = br.readLine();     // 세로 만큼 문자열을 입력 받음
            for (int j = 1; j <= N; j++) {  // 가로 크기인 N만큼 반복을 진행
                // 문자열을 앞에서부터 순서대로 확인
                // 0이면 true, 1이면 false로 저장
                // 0이면 전류가 잘 통한다고 했기 때문에 0 값을 true로 생각한다.
                map[i][j] = str.charAt(j - 1) == '0';   // 문자열에서 문자 하나씩 확인했을때 0과 같다면 true를 저장, 1이면 false를 저장
            }
        }

        for (int j = 1; j <= N; j++) {
            if (map[1][j]) {        // 맨 윗줄(outer side)부터 dfs를 진행 
                dfs(1, j);
            }
        }

        if (answer) {       // answer가 true인지 확인
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.close();
        br.close();
    }
}
