class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int round = 0;
        int dartResultLength = dartResult.length();
        int dartResultIdx = 0;

        while (dartResultIdx < dartResultLength) {
            // 점수 체크
            char ch = dartResult.charAt(dartResultIdx);
            int score = 0;

            // 점수가 10인 경우
            if (ch == '1' && dartResultIdx + 1 < dartResultLength && dartResult.charAt(dartResultIdx + 1) == '0') {
                score = 10;
                dartResultIdx++;
            } else { // 나머지
                score = ch - '0';
            }
            scores[round] = score;
            dartResultIdx++;

            // 보너스 점수 처리 (S, D, T)
            ch = dartResult.charAt(dartResultIdx);
            if (ch == 'S') {
                scores[round] = (int) Math.pow(scores[round], 1);
            } else if (ch == 'D') {
                scores[round] = (int) Math.pow(scores[round], 2);
            } else if (ch == 'T') {
                scores[round] = (int) Math.pow(scores[round], 3);
            }
            dartResultIdx++;

            // 옵션 처리 (*, #)
            if (dartResultIdx < dartResultLength) {
                ch = dartResult.charAt(dartResultIdx);
                if (ch == '*') {
                    scores[round] *= 2; 
                    if (round > 0) {
                        scores[round - 1] *= 2;
                    }
                    dartResultIdx++;
                } else if (ch == '#') {
                    scores[round] *= -1; 
                    dartResultIdx++;
                }
            }
            round++;
        }

        // 최종 점수 계산
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}