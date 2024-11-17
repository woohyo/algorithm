class Solution {
    public int solution(int[] numbers) {
        int totalNum = 45;

        for(int number : numbers) {
            totalNum -= number;
        }
        return totalNum;
    }
}