class Solution {
    
    public int answer;
    public boolean[] visited;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        back(0, 0, 0, number);
        return answer;
    }
    
    public void back(int index, int depth, int sum, int[] number) {
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for (int i = index; i < number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(i + 1, depth + 1, sum + number[i], number);
                visited[i] = false;
            }
        }
    }
}