class Solution {
    long depth;
    int[] result;

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] v = new boolean[n];

        k--;

        for (int i = 0; i < n; i++) {
            long num = facto(n - i - 1);
            int idx = (int) (k / num);
            k %= num;

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (!v[j]) {
                    if (count == idx) {
                        answer[i] = j + 1;
                        v[j] = true;
                        break;
                    }
                    count++;
                }
            }
        }

        return answer;
    }

    private long facto(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * facto(n - 1);
    }
}