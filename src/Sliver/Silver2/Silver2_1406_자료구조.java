package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver2_1406_자료구조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int N = Integer.parseInt(br.readLine());
        Stack<String> lStack = new Stack<>();
        Stack<String> rStack = new Stack<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            lStack.add(str[i]);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            if (action.equals("P")) {
                lStack.add(st.nextToken());
            } else if (action.equals("L")) {
                if (!lStack.isEmpty()) {
                    rStack.add(lStack.pop());
                }
            } else if (action.equals("B")) {
                if (!lStack.isEmpty()) {
                    lStack.pop();
                }
            } else if (action.equals("D")) {
                if (!rStack.isEmpty()) {
                    lStack.add(rStack.pop());
                }
            }
        }

        while (!lStack.isEmpty()) {
            rStack.add(lStack.pop());
        }

        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }

        System.out.println(sb);
    }
}
