package 프로그래머스.first;

public class 삼진법_뒤집기 {

    public static int test(int n) {
        String value = "";

        while (n != 0) {
            value += n % 3;
            n /= 3;
        }

        return Integer.parseInt(value, 3);
    }

    public static void main(String[] args) {
        System.out.println(test(45));
    }
}
