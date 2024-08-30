class 이웃한칸 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String targetColor = board[h][w]; 
        
        for(int i = 0; i < 4; i++) {
            int nx = h + dx[i]; 
            int ny = w + dy[i]; 
            if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length){
                 if(targetColor.equals(board[nx][ny])) answer++;
            }
        }
        return answer;
    }
}