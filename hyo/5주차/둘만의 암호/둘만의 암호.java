import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            char targetChar = ch;
            int moveCnt = 0;
            
            while (moveCnt < index) {
                targetChar++;
                if (targetChar > 'z') {
                    targetChar = 'a'; 
                }
                if (skip.indexOf(targetChar) == -1) {
                    moveCnt++;
                }
            }// while
            result.append(targetChar);
        }// for
        return result.toString();
    }
}