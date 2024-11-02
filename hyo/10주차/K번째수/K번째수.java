import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0] - 1; 
            int endIdx = commands[i][1];       
            
            int[] tmpArr = Arrays.copyOfRange(array, startIdx, endIdx);
            Arrays.sort(tmpArr);
            
            int k = commands[i][2] - 1;
            answer[i] = tmpArr[k];
        }

        return answer;
    }
}