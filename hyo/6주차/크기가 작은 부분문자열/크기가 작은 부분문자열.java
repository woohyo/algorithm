class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();

        for(int i = 0; i < tLength; i++) {
            if(i + pLength <= tLength) {
                String targetStr = t.substring(i, i + pLength);
                if(Long.parseLong(targetStr) <= Long.parseLong(p)) answer++;
            }
        }
        return answer;
    }
}