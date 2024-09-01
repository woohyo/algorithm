class Solution {
    int result;
    public int solution(int k, int[][] dungeons) {
        boolean[] v = new boolean[dungeons.length];
        result = 0;
        recursive(v, dungeons, 0, 0, k);
        return result;
    }

    private void recursive(boolean[] v, int[][] dungeons, int idx, int cnt, int k) {
        if (idx == v.length) {
            result = Math.max(cnt, result);
            return;
        }

        for (int i = 0; i < v.length; i++) {
            int need = dungeons[i][0];
            int consume = dungeons[i][1];
            if (!v[i] && k >= need) {
                v[i] = true;
                recursive(v, dungeons, idx + 1, cnt + 1, k - consume);
                v[i] = false;
            } else {
                recursive(v, dungeons, idx + 1, cnt, k);
            }

        }
    }
}