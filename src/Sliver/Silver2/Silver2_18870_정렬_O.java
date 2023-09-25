package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Silver2_18870_정렬_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] M = new int[N];
        int[] K = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            K[i] = M[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(K);

        int rank = 0;
        for (int v : K) {
            if (!hashMap.containsKey(v)) {
                hashMap.put(v, rank);
                rank++;
            }
        }

        for (int key : M) {
            int ranking = hashMap.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}
