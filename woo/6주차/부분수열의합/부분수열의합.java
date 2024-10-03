import java.util.*;
public class Main {
    private static int[] arr;
    private static int N;
    private static int S;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        answer = 0;
        findSubsets(0, 0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void findSubsets(int index, int currentSum) {
        if (index == N) {
            if (currentSum == S) {
                answer++;
            }
            return;
        }
        findSubsets(index + 1, currentSum);
        findSubsets(index + 1, currentSum + arr[index]);
    }
}
