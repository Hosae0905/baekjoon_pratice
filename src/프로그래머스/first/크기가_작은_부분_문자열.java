package 프로그래머스.first;

public class 크기가_작은_부분_문자열 {

    public static int test(String t, String p) {
        int answer = 0;
        int value = p.length();
        long num = Long.parseLong(p);

        for (int i = 0; i < t.length() - value + 1; i++) {
            long diff = Long.parseLong(t.substring(i, i + value));
            if (diff <= num) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(test("10203", "15"));
    }
}
