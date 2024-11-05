import java.io.*;
import java.util.*;
/**
 * 각 반의 수학 시험 성적의 통계를 낸다.
 * 각 반의 학생들의 수학 성적이 주어졌을 때 최대 점수, 최소 점수, 점수 차이를 구하는 프로그램을 작성해라.
 *
 * 반의 수 K: 1 <= K <= 100
 * 각 반의 학생 수 N: 2 <= N <= 50
 * 시험 성적 T: 0 <= T <= 100
 *
 * 만약 반의 개수가 최대이고, 각 반 마다 학생 수가 최대라면 100 * 50 = 5000
 * 5000개의 데이터를 정렬하기 때문에 O(n^2) 보다는 더 좋은 시간복잡도가 필요함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());        // 반의 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();         // 결과를 저장할 변수

        LinkedList<Integer>[] lists = new LinkedList[k];        // 수학 성적을 저장할 연결 리스트 배열

        // 각 반마다 학생들의 수학 성적을 연결 리스트로 만들고 내림차순 정렬하여 배열에 저장한다.
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 각 반마다 학생 수
            LinkedList<Integer> list = new LinkedList<>();  // 각 반의 수학 성적을 저장할 연결 리스트

            // 연결 리스트에 수학 성적을 저장한다.
            for(int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 내림차순으로 정렬한다.
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            lists[i] = list;        // 내림차순 정렬한 연결 리스트를 배열에 저장한다.
        }

        // 각 반마다 가장 높은 점수와 가장 낮은 점수 그리고 가장 큰 인접한 점수 차이를 sb에 저장한다.
        for(int i = 0; i < k; i++) {
            sb.append("Class ").append(i + 1).append("\n");     // 몇 반의 성적을 출력할지 저장한다.
            int max = lists[i].getFirst();      // 가장 높은 점수
            int min = lists[i].getLast();       // 가장 낮은 점수
            int gap = 0;        // 인접한 점수 차이를 저장할 변수
            int temp = 0;       // 앞선 학생의 수학 점수를 저장할 임시 변수

            // 각 반의 총 학생 수 만큼 인접한 성적 차이를 저장한다.
            for(int j = 0; j < lists[i].size(); j++) {
                // 만약 현재 인접한 점수차와 앞선 학생의 수학 점수와 현재 학생의 수학 점수 차이를 비교하여 더 크다면 gap을 변경해준다.
                if(gap < temp - lists[i].get(j)) {
                    gap = temp - lists[i].get(j);
                }

                temp = lists[i].get(j);     // 앞선 학생의 점수를 변경해준다.
            }

            // 최종적으로 가장 높은 점수와 가장 낮은 점수 그리고 가장 큰 인접한 점수 차이를 sb에 저장한다.
            sb.append("Max ").append(max).append(", ").append("Min ").append(min).append(", ").append("Largest gap ").append(gap).append("\n");
        }

        System.out.println(sb.toString());
    }
}
