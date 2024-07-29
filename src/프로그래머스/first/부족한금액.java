package 프로그래머스.first;

public class 부족한금액 {

    public static long test(int price, int money, int count) {
        long answer = price;

        for (int i = 2; i <= count; i++) {
            answer += price * i;
        }

        if (answer > 0) {
            return answer -= money;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(test(3, 20, 4));
    }
}
