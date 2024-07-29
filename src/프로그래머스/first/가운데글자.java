package 프로그래머스.first;

public class 가운데글자 {

    public static String test(String s) {
        String answer = "";

        int length = s.length();

        if (length % 2 == 0) {
            answer += s.charAt(length / 2 - 1);
            answer += s.charAt((length / 2 - 1) + 1);
            return answer;
        } else {
            return answer += s.charAt(length / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(test("abcde"));
        System.out.println(test("qwerwe"));
    }
}
