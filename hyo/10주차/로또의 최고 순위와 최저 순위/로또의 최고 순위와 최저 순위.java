import java.util.*;

class Solution {
    public long[] solution(int[] lottos, int[] win_nums) {
        long [] answer = new long[2];
        long zeroCnt = Arrays.stream(lottos)
                .filter(num -> num == 0)
                .count();

        long minMatchingCnt = Arrays.stream(lottos)
                .filter(num -> Arrays.stream(win_nums).anyMatch(target -> target == num))
                .count();

        long maxMatchingCnt = minMatchingCnt + zeroCnt;

        answer[0] = 7 - (maxMatchingCnt == 0 ? 1 : maxMatchingCnt);
        answer[1] = 7 - (minMatchingCnt == 0 ? 1 : minMatchingCnt);
        return answer;
    }
}