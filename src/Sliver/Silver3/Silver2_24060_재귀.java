package Sliver.Silver3;

import java.io.*;
import java.util.*;

public class Silver2_24060_재귀 {

    static int[] A, tmp;
    static int cnt = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[N];
        merge_sort(A, 0, A.length - 1);
        System.out.println(result);
    }

    public static void merge_sort(int[] arr, int p, int r) {
        if (cnt > K) return;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t] = arr[i];
                i++;
            } else {
                tmp[t] = arr[j];
                j++;
            }
            t++;
        }

        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            cnt++;
            if (cnt == K) {
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}
