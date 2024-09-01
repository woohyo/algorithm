import java.util.*;
class Solution {
    private int result;
    private boolean[] prime;
    private Set<Integer> set;
    private boolean[] v;
    public int solution(String numbers) {
        result = 0;
        set = new HashSet<>();
        int maxNum = 10000000;
        v = new boolean[numbers.length()];
        prime = new boolean[maxNum];
        Arrays.fill(prime, true);
        for (int i = 2; i < (int) Math.sqrt(maxNum); i++) {
            int j = 2;
            while (i * j <= maxNum) {
                int now = i * j;
                if (now >= maxNum) break;
                prime[now] = false;
                j++;
            }
        }
        prime[0] = false;
        prime[1] = false;
        recursive(numbers, 0, "");
        for (int s: set) {
            if(prime[s]) result++;
        }
        return result;
    }

    private void recursive(String numbers, int idx, String now) {
        if (numbers.length() < idx) {
            int number = Integer.valueOf(now);
            set.add(number);
            return;
        }

        for (int i =0; i < numbers.length(); i++) {
            if (!v[i]) {
                v[i] = true;
                set.add(Integer.valueOf(now + numbers.charAt(i)));
                recursive(numbers, i + 1, now + numbers.charAt(i));
                v[i] = false;
            }
        }
    }
}