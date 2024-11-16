import java.io.*;
import java.util.*;
/**
 * 백준 1652번
 * 콘도에 있는 방은 N x N의 정사각형 모양이다.
 * 영식이가 누울 자리를 찾아야 한다.
 * 똑바로 연속해서 2칸 이상의 빈 칸이 존재하면 그곳에 몸을 누울 수 있다.
 * 가로로 누울 수도 있고 세로로 누울 수도 있다.
 * 중간에 어쩡쩡하게 눕는 경우가 없다.
 * 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리의 수를 구해라.
 *
 * 방의 크기 N은 1이상 100이하의 정수이다.
 * .은 아무것도 없는 곳을 의미하고 X는 짐이 있는 곳을 의미한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[101][101];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
            arr[i][n] = 'X';
            arr[n][i] = 'X';
        }

        int countX = 0;
        int countY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(arr[i][j] == '.' && arr[i][j + 1] == '.' && arr[i][j + 2] == 'X') {
                    countX++;
                }

                if(arr[j][i] == '.' && arr[j + 1][i] == '.' && arr[j + 2][i] == 'X') {
                    countY++;
                }
            }
        }

        sb.append(countX).append(" ").append(countY);
        System.out.println(sb.toString());
    }
}
