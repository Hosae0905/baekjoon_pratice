package 프로그래머스.first;

public class 문자열_다루기_기본 {
    public static boolean test(String s) {
        boolean answer = true;

        if (s.length() != 4 && s.length() != 6) return !answer;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return !answer;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(test("a234"));
        System.out.println(test("1234"));
        System.out.println(test("123"));
        System.out.println(test("1234567"));
    }
}
