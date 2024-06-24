package 알고리즘;

public class Binary_Search {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                return binarySearch(arr, low, mid - 1, target);
            }

            return binarySearch(arr, mid + 1, high, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 14, 18, 24, 29, 31, 37, 45, 49, 50, 56, 63, 68, 72, 77};
        int target = 50;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println(result);
    }
}
