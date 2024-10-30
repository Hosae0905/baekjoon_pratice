import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/**
 * 성적순서대로 3명에게 금, 은, 동메달을 수여
 * 동점자는 없고 나라별 메달 수는 최대 두개
 * 메달 수상자를 결정하여 출력하는 프로그램을 작성
 *
 * 대회참가 학생 수는 3보다 크거나 같고 100보다 작거나 같다.      --> O(N^2)의 시간복잡도로 해결 가능
 * 국가 번호, 학생 번호, 성적이 주어진다.      --> 하나의 학생 객체가 필요함
 * 점수는 0이상 1000이하다.
 * 동점자는 없고 제공되는 국가는 적어도 두 나라 이상이다.      --> 동점자가 없으니 정렬할 때 중복을 신경쓰지 않아도 됨
 *
 * 메달을 받는 학생들은 금, 은, 동메달 순서대로 한 줄에 한명씩 출력한다.
 * 소속 국가 번호와 학생 번호를 하나의 빈칸을 사이에 두고 출력한다.        --> StringBuilder 활용
 */
class Student {
    int cntNum;     // 국가번호
    int stuNum;     // 학생 번호
    int score;      // 성적

    Student(int cntNum, int stuNum, int score) {
        this.cntNum = cntNum;
        this.stuNum = stuNum;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 총 학생 수
        StringTokenizer st;
        ArrayList<Student> list = new ArrayList<>();        // 학생 정보를 저장할 리스트
        StringBuilder sb = new StringBuilder();             // 결과를 저장할 변수

        // 입력 받은 총 학생 수만큼 학생 객체를 만들어 리스트에 저장한다.
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cntNum = Integer.parseInt(st.nextToken());
            int stuNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Student(cntNum, stuNum, score));
        }

        // 리스트를 정렬하는데 성적 순으로 내림차순 정렬을 진행한다.
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });
        
        sb.append(list.get(0).cntNum).append(" ").append(list.get(0).stuNum).append("\n");      // 금메달 받은 학생
        sb.append(list.get(1).cntNum).append(" ").append(list.get(1).stuNum).append("\n");      // 은메달 받은 학생

        // 리스트에 저장된 학생을 하나씩 꺼내서 sb에 저장한다.
        for(int i = 2; i < list.size(); i++) {

            // 만약 금메달을 받은 학생의 국가 번호와 같지 않다면 sb에 저장한다.
            if (list.get(0).cntNum != list.get(i).cntNum) {
                sb.append(list.get(i).cntNum).append(" ").append(list.get(i).stuNum).append("\n");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}
