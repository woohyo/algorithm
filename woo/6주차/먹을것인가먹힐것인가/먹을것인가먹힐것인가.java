import java.util.*;
public class Main {
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            answer = 0;
            int A = sc.nextInt();
            int B = sc.nextInt();
            int[] aGroup = new int[A];
            int[] bGroup = new int[B];
            for (int j = 0; j < A; j++) {
                aGroup[j] = sc.nextInt();
            }

            for (int j = 0; j < B; j++) {
                bGroup[j] = sc.nextInt();
            }
            Arrays.sort(aGroup);
            Arrays.sort(bGroup);

            for (int i1 : aGroup) {
                bs(bGroup, i1);
            }
            System.out.println(answer);
        }
    }

    private static void bs(int[] bGroup, int num) {
        int right = bGroup.length - 1;
        int left = 0;
        int result = -1;
        while (left <= right) {
            int idx = (left + right) / 2;
            if (bGroup[idx] < num) {
                left = idx + 1;
                result = idx;
            } else {
                right = idx - 1;
            }
        }
        answer += result + 1;
    }
}