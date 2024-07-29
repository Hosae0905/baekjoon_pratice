package 프로그래머스.first;

public class 약수의개수와덧셈 {

    public static int divisor(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (i * i == number) count++;
            else if (number % i == 0) count += 2;
        }

        return count;
    }

    public static int test(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = divisor(i);
            if (count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(test(13, 17));
        System.out.println(test(24, 27));
    }
}
