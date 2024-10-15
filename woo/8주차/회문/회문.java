import java.util.Scanner;

public class Main {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            check(s);
        }
    }

    private static void check(String s) {
        if (isPalindrome(s)) {
            System.out.println("0");
            return;
        }

        if (isAlmostPalindrome(s)) {
            System.out.println("1");
            return;
        }

        System.out.println("2");
    }

    private static boolean isPalindrome(String s) {
        int lIdx = 0;
        int rIdx = s.length() - 1;
        while (lIdx < rIdx) {
            if (s.charAt(lIdx) != s.charAt(rIdx)) {
                return false;
            }
            lIdx++;
            rIdx--;
        }
        return true;
    }

    private static boolean isAlmostPalindrome(String s) {
        int lIdx = 0;
        int rIdx = s.length() - 1;
        while (lIdx < rIdx) {
            if (s.charAt(lIdx) != s.charAt(rIdx)) {
                return isPalindrome(s.substring(lIdx + 1, rIdx + 1)) || isPalindrome(s.substring(lIdx, rIdx));
            }
            lIdx++;
            rIdx--;
        }
        return false;
    }
}
