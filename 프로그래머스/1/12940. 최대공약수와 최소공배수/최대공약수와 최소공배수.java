class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;

        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }
    
    public int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }
}