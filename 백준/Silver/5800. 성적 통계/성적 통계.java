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

        // 각 반마다 학생들의 수학 성적을 연결 리스트로 만들고 내림차순 정렬하여 배열에 저장한다.
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 각 반마다 학생 수
            LinkedList<Integer> list = new LinkedList<>();  // 각 반의 수학 성적을 저장할 연결 리스트

            sb.append("Class ").append(i + 1).append("\n");     // 몇 반의 성적을 출력할지 저장한다.

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

            int max = list.getFirst();      // 가장 높은 점수
            int min = list.getLast();       // 가장 낮은 점수
            int gap = 0;                    // 인접한 점수 차이를 저장할 변수

            // 각 반의 총 학생 수 만큼 인접한 성적 차이를 저장한다.
            for(int j = 0; j < list.size() - 1; j++) {

                /*
                * 만약 학생의 성적이 gap 보다 작다면 현재 gap이 가장 높은 인접한 점수인 것을 알 수 있다.
                * 예를 들어 첫 번째 예저를 보면 76과 30의 차이는 46이다.
                * 만약 다음에 숫자가 0이 오더라도 그 차이는 46이 되기 때문에 결국 점수가 gap보다 작다면 해당 gap 최댓값인 것을 알 수 있다.
                * */
                if (list.get(j) < gap) {
                    break;
                }

                // 만약 현재 인접한 점수차와 앞선 학생의 수학 점수와 현재 학생의 수학 점수 차이를 비교하여 더 크다면 gap을 변경해준다.
                gap = Math.max(gap, list.get(j) - list.get(j + 1));
            }

            // 최종적으로 가장 높은 점수와 가장 낮은 점수 그리고 가장 큰 인접한 점수 차이를 sb에 저장한다.
            sb.append("Max ").append(max).append(", ").append("Min ").append(min).append(", ").append("Largest gap ").append(gap).append("\n");
        }

        System.out.println(sb.toString());
    }
}
