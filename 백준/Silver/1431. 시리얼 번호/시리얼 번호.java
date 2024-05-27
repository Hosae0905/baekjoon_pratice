import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sumA = 0;
                    int sumB = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            sumA += o1.charAt(i) - 48;
                        }
                    }

                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                            sumB += o2.charAt(i) - 48;
                        }
                    }

                    if (sumA == sumB) {
                        return o1.compareTo(o2);
                    } else {
                        return sumA - sumB;
                    }
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
