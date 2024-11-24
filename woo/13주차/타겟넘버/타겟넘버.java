class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, target, numbers, 0);
        return answer;
    }

    private void dfs(int idx, int target, int[] numbers, int num) {
        if (idx == numbers.length) {
            if (target == num) answer++;
            return;
        }

        dfs(idx + 1, target, numbers, num + numbers[idx]);
        dfs(idx + 1, target, numbers, num - numbers[idx]);
    }
}