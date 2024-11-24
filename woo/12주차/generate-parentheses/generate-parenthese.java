import java.util.*;
class Solution {
    private List<String> answer;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        recursive(0, n, 0, "");
        return answer;
    }
    private void recursive(int depth, int n, int s, String str) {
        if (depth > n) return;
        if (depth == n && s == 0) {
            answer.add(str);
            return;
        }

        if (s == 0) {
            recursive(depth + 1, n, s + 1, str + "(");
        } else {
            recursive(depth + 1, n, s + 1, str + "(");
            recursive(depth, n, s - 1, str + ")");
        }
    }
}