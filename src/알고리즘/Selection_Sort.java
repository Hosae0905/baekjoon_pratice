package 알고리즘;

public class Selection_Sort {

    public static int[] selection_sort(int[] arr) {
        return selection_sort(arr, arr.length);
    }

    private static int[] selection_sort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            
            // 현재 배열에서 최솟값을 찾기
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 현재 i번째 값과 최솟값을 서로 교환하기
            swap(arr, min, i);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 8, 9, 4, 6, 1, 5};
        int[] result = selection_sort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
