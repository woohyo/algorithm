import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long answer = 0;
        long left = 0;
        long right = num;

        while (left <= right) {
            long mid = (left + right) / 2;

            if ((double) mid * mid >= num) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
