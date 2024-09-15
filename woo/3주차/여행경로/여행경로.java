class Solution {
    String[] result;
    public String[] solution(String[][] tickets) {
        result = null; // Initialize result
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] v = new boolean[tickets.length];
                String[] ans = new String[tickets.length + 1];
                v[i] = true;
                ans[0] = "ICN";
                ans[1] = tickets[i][1];
                dfs(tickets, 2, v, ans, tickets[i][1]);
            }
        }
        return result;
    }

    private void dfs(String[][] tickets, int depth, boolean[] v, String[] answer, String now) {
        if (depth == tickets.length + 1) {
            // Check if all tickets are used
            boolean error = false;
            for (boolean b : v) {
                if (!b) {
                    error = true;
                    break;
                }
            }
            if (!error) {
                if (result != null) {
                    compareAndSetResult(answer);
                } else {
                    result = answer.clone(); // Clone the array
                }
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!v[i] && tickets[i][0].equals(now)) {
                v[i] = true;
                answer[depth] = tickets[i][1];
                dfs(tickets, depth + 1, v, answer, tickets[i][1]);
                v[i] = false; // Backtrack
            }
        }
    }

    private void compareAndSetResult(String[] answer) {
        for (int i = 0; i < answer.length; i++) {
            int cmp = answer[i].compareTo(result[i]);
            if (cmp < 0) {
                result = answer.clone();
                break;
            } else if (cmp > 0) {
                break;
            }
        }
    }
}