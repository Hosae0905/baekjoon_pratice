import java.util.*;

class Solution {
    static ArrayList<Integer>[] node;
    static int min;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        node = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            node[v1].add(v2);
            node[v2].add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            boolean[] visited = new boolean[n + 1];

            node[v1].remove(Integer.valueOf(v2));
            node[v2].remove(Integer.valueOf(v1));

            int count = dfs(1, visited);

            int diff = Math.abs(count - (n - count));
            min = Math.min(min, diff);

            node[v1].add(v2);
            node[v2].add(v1);
        }

        return min;
    }

    private static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;

        for (int next : node[v]) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
    }
}