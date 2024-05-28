import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        recursive(0, "");
        System.out.println(sb);
    }

    public static void recursive(int index, String tap) {
        if (index == N) {
            sb.append(tap).append("\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(tap).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(tap).append("라고 답변하였지.").append("\n");
            return;
        } else {
            sb.append(tap).append("\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(tap).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
            sb.append(tap).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
            sb.append(tap).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
            recursive(++index, tap + "____");
            sb.append(tap).append("라고 답변하였지.").append("\n");
        }
    }
}
