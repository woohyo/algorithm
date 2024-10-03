import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> charIdxMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            int nearCharDistance = -1;
            char targetChar = s.charAt(i);
            if(i != 0 && containsKeyForChar(charIdxMap, targetChar)) {
                nearCharDistance = i - getValueForChar(charIdxMap, targetChar);
            }
            charIdxMap.put(targetChar, i);
            answer[i] = nearCharDistance;
        }
        return answer;
    }

    public boolean containsKeyForChar(HashMap<Character, Integer> map, char targetChar) {
        return map.keySet().stream()
                .anyMatch(c -> c == targetChar);
    }

    public int getValueForChar(HashMap<Character, Integer> map, char targetChar) {
        int value = 0;
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == targetChar) value =  entry.getValue();
        }
        return value;
    }
}