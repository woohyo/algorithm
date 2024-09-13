class Solution {
    int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            boolean can = canTransform(begin, words[i]);
            if (can) {
                boolean[] v = new boolean[words.length];
                v[i] = true;
                dfs(target, words[i], words, 0, v);
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer + 1;
    }

    private void dfs(String target, String begin, String[] words, int depth, boolean[] v) {
        if (target.equals(begin)) {
            answer = Math.min(answer, depth);
            return;
        }
        if (depth > words.length) return;

        for (int i = 0; i < words.length; i++) {
            if (!v[i]) {
                boolean can = canTransform(words[i], begin);
                if (can) {
                    v[i] = true;
                    dfs(target, words[i], words, depth + 1, v);
                    v[i] = false;
                }
            }
        }
    }

    private boolean canTransform(String a, String b) {
        int dif = 0;
        for (int i =0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dif++;
        }

        return dif <= 1;
    }
}