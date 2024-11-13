import java.io.*;
import java.util.*;

/**
 * 백준 9196번
 * 정수 직사각형은 높이 h와 너비 w가 자연수이다.
 * 넓은 정수 직사각형은 w가 h보다 큰 것을 의미한다.
 * 넓은 정수 직사각형의 순서는 다음과 같이 정할 수 있다.
 *  1. 대각선의 길이가 짧은 쪽이 작다.
 *  2. 대각선의 길이가 같은 경우에는 높이가 작은 것이 작다.
 * 넓은 정수 직사각형이 주어졌을 때 그 직사각형보다 큰 직사각형 중 가장 작은 것을 찾는 프로그램을 작성해라.
 *
 * 테스트 케이스 T: 0 < T < 100
 * 높이 h: 0 < h < 100
 * 너비 w: 0 < w < 100 (단, h보다는 항상 크다)
 * 입력의 마지막 줄에는 0이 두개 주어진다.
 * 입력으로 주어진 넓은 정수 직사각형보다 큰 직사각형 중 가장 작은 넓은 정수 직사각형의 노이와 너비를 출력한다. 이때 해당 값은 150을 넘지 않는다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str = "";
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 1; i <= 150; i++) {
            for (int j = i; j <= 150; j++) {
                if (i == j) {
                    continue;
                }

                list.add(new int[]{i, j});
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diag1 = (o1[0] * o1[0]) + (o1[1] * o1[1]);
                int diag2 = (o2[0] * o2[0]) + (o2[1] * o2[1]);

                if (diag1 != diag2) {
                    return diag1 - diag2;
                } else {
                    return o1[0] - o2[0];
                }
            }
        });


        while(!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] arr = {h, w};
            int index = -1;

            for(int i = 0; i < list.size(); i++) {
                if(Arrays.equals(list.get(i), arr)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                int[] result = list.get(index + 1);
                sb.append(result[0]).append(" ").append(result[1]).append("\n");
            }

        }

        System.out.println(sb.toString());
    }
}
