class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isFound = false;

        do {
            answer++;
            if(n % answer == 1) isFound = true;
        }
        while (!isFound);

        return answer;
    }
}