package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver3_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int M = Integer.parseInt(br.readLine());
        int[] C = new int[M];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < B.length; i++) {
            if (A[i] == 0) {
                queue.add(B[i]);
            }
            else {
                stack.push(B[i]);
            }
        }

        for (int i = 0; i < C.length; i++) {

        }

    }
}
