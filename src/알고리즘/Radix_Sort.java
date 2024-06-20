package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;

public class Radix_Sort {
    private static void radix_sort(int[] arr) {
        // 10진수 큐 생성
        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<>();
        }

        int maxLength = maxDigitCount(arr);
        // 각 자리수의 숫자를 저장
        int digitNumber = 0;
        // 배열에 다시 저장할 때 필요한 변수
        int index = 0;

        // 자리수 만큼 반복
        for (int i = 0; i < maxLength; i++) {
            // 데이터의 개수만큼 반복
            for (int j = 0; j < arr.length; j++) {
                digitNumber = getDigit(arr[j], i);
                queues[digitNumber].add(arr[j]);
            }

            // 큐에 들어간 데이터를 순서대로 꺼내 배열에 덮어씌운다.
            for (int j = 0; j < arr.length; j++) {
                while (!queues[j].isEmpty()) {
                    arr[index++] = queues[j].remove();
                }
            }

            index = 0;
        }

    }

    // 숫자의 자리수를 변환해준다.
    private static int getDigit(int num, int index) {
        return (int)Math.floor(Math.abs(num) / Math.pow(10, index)) % 10;
    }

    // 숫자의 자리수를 구해준다.
    private static int digitCount(int num) {
        if (num == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }

    // 배열에 있는 데이터 중 가장 큰 자리수를 반환해준다.
    private static int maxDigitCount(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, digitCount(arr[i]));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 11, 20, 4, 15, 17, 30};
        radix_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
