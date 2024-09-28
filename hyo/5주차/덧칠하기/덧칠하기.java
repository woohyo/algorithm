class Solution {
    public int solution(int n, int m, int[] sections) {
        int paintCount = 0;
        int paintComplIdx = 0;
        
        for (int section : sections) {
            if (section <= paintComplIdx) {
                continue;
            }
            paintCount++;
            paintComplIdx = section + m - 1;
        }

        return paintCount;
    }
}