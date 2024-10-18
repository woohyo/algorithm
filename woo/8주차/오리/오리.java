import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static String N;
    private static int answer;
    private static boolean[] v;
    private static String QUACK = "quack";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.next();
        answer = 0;
        v = new boolean[N.length()];
        if (N.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < N.length(); i++) {
            if (!v[i] && N.charAt(i) == 'q') {
                track(i);
            }
        }

        for (boolean b : v) {
            if (!b) {
                answer = 0;
                break;
            }
        }
        answer = answer == 0 ? -1 : answer;
        System.out.println(answer);
    }

    static void track(int start) {
        int j = 0;
        boolean first = true;
        for (int i = start; i < N.length(); i++) {
            if (N.charAt(i) == QUACK.charAt(j) && !v[i]) {
                v[i] = true;
                if (N.charAt(i) == 'k') {
                    if (first) {
                        answer++;
                        first = false;
                    }
                    j = 0;
                    continue;
                }
                j ++;
            }
        }
    }
}