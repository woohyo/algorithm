import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] str = new String[N];
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = binarySearch(nums, num);
            bw.write(str[idx] + "\n");
        }

        bw.flush();
        bw.close();
    }


    public static int binarySearch(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}