class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String st: skill_trees) {
            int idx = 0;
            boolean error = false;
            for (char s: st.toCharArray()) {
                if (skill.contains(String.valueOf(s)) && skill.charAt(idx) != s) {
                    error = true;
                    break;
                } else if (skill.contains(String.valueOf(s)) && skill.charAt(idx) == s) {
                    idx++;
                }
            }
            if (!error) answer++;
        }
        return answer;
    }
}