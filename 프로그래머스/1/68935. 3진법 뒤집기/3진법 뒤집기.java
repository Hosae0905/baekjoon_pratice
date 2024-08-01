class Solution {
    public int solution(int n) {
        String value = "";

        while (n != 0) {
            value += n % 3;
            n /= 3;
        }

        return Integer.parseInt(value, 3);
    }
}