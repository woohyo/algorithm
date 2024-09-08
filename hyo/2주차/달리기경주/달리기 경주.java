import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> playerIdxMap = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            playerIdxMap.put(players[i], i);
        }

        // calling은 무조건 1이상
        for(String calling : callings){
            int callIdx = playerIdxMap.get(calling);
            players[callIdx] = players[callIdx-1];
            players[callIdx-1] = calling;
            
            playerIdxMap.put(players[callIdx], callIdx);
            playerIdxMap.put(players[callIdx-1], callIdx-1);
        }

        answer = players;
        return answer;
    }
}