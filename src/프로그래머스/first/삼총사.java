package 프로그래머스.first;

public class 삼총사 {
    public static int answer;
    public static boolean[] visited;
    public static int test(int[] number) {
        visited = new boolean[number.length];
        back(0, 0, 0, number);
        return answer;
    }

    public static void back(int index, int depth, int sum, int[] number) {
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

    public static void main(String[] args) {
//        int[] arr = {-2, 3, 0, 2, -5};
//        int[] arr1 = {-3, -2, -1, 0, 1, 2, 3};
        int[] arr2 = {-1, 1, -1, 1};
//        System.out.println("arr = " + test(arr));
//        System.out.println("arr1 = " + test(arr1));
        System.out.println("arr2 = " + test(arr2));
    }
}
