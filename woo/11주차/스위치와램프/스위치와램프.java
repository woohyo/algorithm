import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer>[] graph;
    private static int[] match;
    private static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N + 1];
        match = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            int cnt = sc.nextInt();
            graph[i] = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                int temp = sc.nextInt();
                graph[i].add(temp);
                match[temp]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isPossible(i)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    private static boolean isPossible(int idx) {
        boolean flag = true;

        for (Integer i : graph[idx]) {
            match[i]--;
            if (match[i] <= 0) {
                flag = false;
            }
        }


        for (Integer i : graph[idx]) {
            match[i]++;
        }
        return flag;
    }
}
