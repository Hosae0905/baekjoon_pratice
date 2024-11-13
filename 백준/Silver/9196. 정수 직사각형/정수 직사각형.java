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
 * 입력으로 주어진 넓은 정수 직사각형보다 큰 직사각형 중 가장 작은 넓은 정수 직사각형의 높이와 너비를 출력한다. 이때 해당 값은 150을 넘지 않는다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();         // 결과를 저장할 변수
        String str = "";                // 입력 값을 받을 문자열 초기화
        ArrayList<int[]> list = new ArrayList<>();      // 직사각형을 저장할 리스트

        /*
        * 넓은 정수 직사각형의 높이와 너비 값은 최대 150을 넘지 않기 때문에 반복문을 통해서 150 전까지의 모든 직사각형의 길이를 구한다.
        * 이때 너비의 값은 높이 보다는 무조건 커야 되기 때문에 너비(j)를 구할 때는 i부터 시작한다.
        * */
        for (int i = 1; i <= 150; i++) {
            for (int j = i; j <= 150; j++) {
                // 만약 높이(i)와 너비(j)가 같다면 반복문을 계속 진행한다.
                if (i == j) {
                    continue;
                }

                list.add(new int[]{i, j});      // 높이와 너비가 다르다면 해당 값을 바탕으로 정수 배열을 만들어 리스트에 저장한다.
            }
        }

        // 정수 직사각형을 오름차순으로 정렬한다.
        Collections.sort(list, new Comparator<int[]>() {
            /**
             * 오름차순으로 정렬하는 메서드
             * @param o1 첫 번째 비교 대상
             * @param o2 두 번째 비교 대상
             * @return -1(앞으로 이동) | 0(제자리) | 1(뒤로 이동)
             */
            @Override
            public int compare(int[] o1, int[] o2) {
                int diag1 = (o1[0] * o1[0]) + (o1[1] * o1[1]);      // 비교할 정수 직사각형의 대각선 길이를 구한다.(피타고라스 정리 활용)
                int diag2 = (o2[0] * o2[0]) + (o2[1] * o2[1]);

                /**
                 * 만약 두 직사각형의 대각선 길이가 다르다면 대각선의 길이를 기준으로 오름차순 정렬을 한다.
                 * 그렇지 않다면 높이를 기준으로 오름차순 정렬을 한다.
                 */
                if (diag1 != diag2) {
                    return diag1 - diag2;
                } else {
                    return o1[0] - o2[0];
                }
            }
        });


        /**
         * 입력 값을 받아서 해당 입력 값 보다 큰 것 중에서 가장 작은 정수 직사각형을 찾는다.
         * 이때 입력 값이 "0 0"이면 반복문을 종료한다.
         */
        while(!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            int h = Integer.parseInt(st.nextToken());       // 입력 값 중에서 높이 값을 저장한다.
            int w = Integer.parseInt(st.nextToken());       // 입력 값 중에서 너비 값을 저장한다.

            int[] arr = {h, w};     // 높이와 너비를 가지고 정수 배열을 생성한다.
            int index = -1;         // 인덱스를 생성하여 찾은 정수 직사각형의 위치를 저장한다. (초기 값은 -1)

            // 길이가 150이전까지의 직사각형이 들어있는 리스트에서 입력 값으로 받은 높이와 너비의 인덱스 값을 확인한다.
            for(int i = 0; i < list.size(); i++) {
                // 만약 입력 값과 일치하는 배열을 찾았다면 해당 인덱스를 변수에 저장하고 반복문을 종료한다.
                if(Arrays.equals(list.get(i), arr)) {
                    index = i;
                    break;
                }
            }

            // 만약 index가 -1이 아니라면(즉, 입력 값과 동일한 배열이 있다면 결과를 sb에 저장한다.
            if (index != -1) {
                /**
                 * 입력 값보다 큰 직사각형 중에서 가장 작은 것을 찾아야 하기 때문에
                 * 이전에 구했던 index에 1을 더한 위치의 값이 가장 작은 직사각형이 된다. (정렬을 했기 때문에 가능함)
                 */
                int[] result = list.get(index + 1);
                sb.append(result[0]).append(" ").append(result[1]).append("\n");        // [0]: 높이, [1]: 너비
            }

        }

        System.out.println(sb.toString());
    }
}
