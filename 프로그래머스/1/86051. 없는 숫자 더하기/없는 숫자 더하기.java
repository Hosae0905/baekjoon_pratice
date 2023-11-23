class Solution {
    public int solution(int[] numbers) {
        int count = 1;

        int a = 0;
        int b = 0;

        for (int i = 0; i < 9; i++) {
            a += count++;
        }

        for (int i = 0; i < numbers.length; i++) {
            b += numbers[i];
        }

        return a - b;
    }
}