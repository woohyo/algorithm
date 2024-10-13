import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] honor = new int[k];

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                honor[k - 1 - i] = score[i];
            } else {
                if (honor[0] < score[i]) {
                    honor[0] = score[i];
                }
            }
            // 오름차순으로 정렬
            Arrays.sort(honor);

            // 최하위 점수 기록
            answer[i] = i < k - 1 ? honor[k - 1 - i] : honor[0];
        }
        return answer;
    }
}