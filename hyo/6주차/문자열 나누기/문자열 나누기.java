class Solution {
    public int solution(String s) {
        int partCnt = 0;
        int sameCharCnt = 0;
        int diffCharCnt = 0;
        char firstChar = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == firstChar) {
                sameCharCnt++;
            } else {
                diffCharCnt++;
            }
            
            if (sameCharCnt == diffCharCnt || i == s.length() - 1) {
                partCnt++;
                if (i + 1 < s.length()) {
                    firstChar = s.charAt(i + 1);
                }
                sameCharCnt = 0;
                diffCharCnt = 0;
            }
        }
        return partCnt;
    }
}