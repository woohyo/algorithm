class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) { // 0 1 2
            for (int j = i + 1; j < number.length - 1; j++) { // 1 2 3
                for (int k = j + 1; k < number.length; k++) {  // 2 3 4
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}