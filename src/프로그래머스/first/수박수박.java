package 프로그래머스.first;

public class 수박수박 {

    public static String test(int n) {
        StringBuilder sb = new StringBuilder();
//        String answer = "";
//
//        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 1) answer += "수";
//            else answer += "박";
//        }
//
//        return answer;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) sb.append("수");
            else sb.append("박");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(test(3));
        System.out.println(test(4));
    }
}
