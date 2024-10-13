class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++) {
            for(int j = 1; j <= food[i] / 2; j++) {
                answer += i;
            }
        }
        answer = new StringBuilder(answer)
                .append('0')
                .append(new StringBuilder(answer).reverse())
                .toString();
        
        return answer;
    }
}