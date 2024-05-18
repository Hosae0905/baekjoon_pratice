package Sliver.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class Silver4_1388_DFS {
    final static int MAX = 50 + 10;     // 방 바닥의 최대 크기 50
    static char[][] map;        // 방 바닥의 정보를 담을 2차원 배열(문자로 주어지기 때문에 char 타입으로 선언)
    static boolean[][] visited; // 방문을 체크할 2차원 배열
    static int N, M;        // N: 세로(열), M: 가로(행)

    public static void dfs(int y, int x) {
        visited[y][x] = true;       // y, x에 위치한 노드를 방문 체크

        // MAX를 넉넉하게 10을 더 줬기 때문에 인덱스가 넘어가버리는 에러가 발생하지 않음
        if (map[y][x] == '-' && map[y][x + 1] == '-') {     // y, x에 위치한 곳의 바닥 장식이 '-' 이고, 그 다음 행의 장식도 '-'라면 dfs를 진행
            dfs(y, x + 1);      // 같은 행을 탐색해야 되기 때문에 x 좌표 값을 증가
        }

        if (map[y][x] == '|' && map[y + 1][x] == '|') {     // y, x에 위치한 곳의 바닥 장식이 '|' 이고, 그 다음 행의 장식도 '|'라면 dfs를 진행
            dfs(y + 1, x);      // 같은 열을 탐색해야 되기 때문에 y 좌표 값을 증가
        }
    }
    public static void main(String[] args) throws IOException {
        // 0. 입력과 초기화를 진행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 세로(열) 크기
        M = Integer.parseInt(st.nextToken());       // 가로(행) 크기

        map = new char[MAX][MAX];           // MAX 값으로 map 생성
        visited = new boolean[MAX][MAX];    // MAX 값으로 방문 배열 생성

        // 1. map에 바닥 장식 데이터를 저장
        for (int i = 1; i <= N; i++) {      // 세로(열) N 만큼 반복
            String str = br.readLine();     // 한 줄씩 입력 값을 받기
            for (int j = 1; j <= M; j++) {  // 가로(행) M 만큼 반복
                map[i][j] = str.charAt(j - 1);  // 입력 값은 0번부터 시작하기 때문에 j에서 -1을 하여 데이터를 저장
            }
        }

        int answer = 0;     // 정답 변수 초기화

        // 2. DFS 진행
        for (int i = 1; i <= N; i++) {      // 세로(열) N 만큼 반복
            for (int j = 1; j <= M; j++) {  // 가로(행) M 만큼 반복
                if (!visited[i][j]) {       // i, j 위치에 있는 노드를 방문하지 않았을 경우 dfs를 진행
                    dfs(i, j);      
                    answer++;       // 인접한 행 혹은 열끼리는 같은 나무판자를 사용하기 때문에 answer값은 1 증가
                }
            }
        }

        bw.write(String.valueOf(answer));       // 정답 출력

        bw.close();
        br.close();
    }
}
