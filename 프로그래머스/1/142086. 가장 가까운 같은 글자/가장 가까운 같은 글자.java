import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> resultDstList = new ArrayList<>();
        HashMap<Integer, Character> charIdxMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            int nearCharDst = -1;
            char targetChar = s.charAt(i);
            if(i != 0 && containsValueForChar(charIdxMap, targetChar)) {
                nearCharDst = i - getMaxKeyForChar(charIdxMap, targetChar);
            }
            charIdxMap.put(i, targetChar);
            resultDstList.add(nearCharDst);
        }
        return resultDstList.stream().mapToInt(i -> i).toArray();
    }

    public boolean containsValueForChar(HashMap<Integer, Character> map, char targetChar) {
        for (HashMap.Entry<Integer, Character> entry : map.entrySet()) {
            if (entry.getValue() == targetChar) {
                return true;
            }
        }
        return false;
    }

    public int getMaxKeyForChar(HashMap<Integer, Character> map, char targetChar) {
        int maxKey = 0;
        for (HashMap.Entry<Integer, Character> entry : map.entrySet()) {
            if (entry.getValue() == targetChar && entry.getKey() > maxKey) {
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}