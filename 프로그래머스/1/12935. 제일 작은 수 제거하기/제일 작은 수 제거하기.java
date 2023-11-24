class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }

        int min = arr[0];
        int[] answer = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                continue;
            } else {
                answer[count++] = arr[i];
            }
        }

        return answer;
    }
}