import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        ArrayList<Integer> pushCntList = new ArrayList<>();
        for(String target : targets) {
            int cnt = 0;
            boolean notFound = false;

            for (int i = 0; i < target.length(); i++) {
                char targetCh = target.charAt(i);
                int keyIdx = findIndexOfStringWithCh(keymap, targetCh);
                if (keyIdx == -1) {
                    cnt = -1;
                    notFound = true;
                    break;
                }
                cnt += (keymap[keyIdx].indexOf(targetCh) + 1);
            }
            pushCntList.add(notFound ? -1 : cnt);
        }
        return pushCntList.stream().mapToInt(i -> i).toArray();
    }
    
    public int findIndexOfStringWithCh(String[] arr, char ch) {
        int minAIndex = Integer.MAX_VALUE;
        int resultIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int indexOfCh = str.indexOf(ch);
            if (indexOfCh != -1) {
                if (indexOfCh < minAIndex) {
                    minAIndex = indexOfCh;
                    resultIndex = i;
                }
            }
        }
        return resultIndex;
    }
}