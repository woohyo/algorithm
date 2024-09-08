import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);

        for(int i = 0; i < survey.length; i++) {
            Character firtType = survey[i].charAt(0);
            Character secondType = survey[i].charAt(1);
           if(choices[i] >= 1 && choices[i] < 4) {  // 비동의
               scoreMap.put(firtType, scoreMap.get(firtType) + (4 - choices[i]));
           } else if(choices[i] > 4 && choices[i] <= 7) {  // 동의
               scoreMap.put(secondType, scoreMap.get(secondType) + (choices[i] - 4));
           }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(scoreMap.get('R') >= scoreMap.get('T') ? "R" : "T");
        sb.append(scoreMap.get('C') >= scoreMap.get('F') ? "C" : "F");
        sb.append(scoreMap.get('J') >= scoreMap.get('M') ? "J" : "M");
        sb.append(scoreMap.get('A') >= scoreMap.get('N') ? "A" : "N");
        answer = sb.toString();
        return answer;
    }
}