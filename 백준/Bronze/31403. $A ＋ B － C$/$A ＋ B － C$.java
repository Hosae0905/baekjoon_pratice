import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int num = a + b - c;
        String str = a + "" + b;
        int num2 = Integer.parseInt(str);
        num2 -= c;

        System.out.println(num);
        System.out.println(num2);
    }
}
