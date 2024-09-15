class Solution {
    public int solution(int[][] board, int[] moves) {
        int removeCnt = 0;
        IntStack stack = new IntStack(moves.length); // 뽑은 인형 스택
        boolean isSucc;

        for(int move : moves) {
            isSucc = false;
            for(int i = 0; i < board.length; i++){
                if(isSucc == true) {
                    continue;
                }
                int targetNum = board[i][move - 1];
                if( targetNum == 0) {
                    continue;
                } else {
                    int peekNum = stack.peek();
                    if( peekNum == -1 || peekNum != targetNum) {
                        stack.push(targetNum);
                    } else {
                        // 같은 숫자가 이미 있는 경우
                        stack.pop();
                        removeCnt += 2;
                    }
                    board[i][move - 1] = 0;
                    isSucc = true;
                }
            } //for
        } //for
        return removeCnt;
    }
    
    public class IntStack {
        private int[] stack;
        private int top;
        private int size;

        public IntStack(int size) {
            this.size = size;
            stack = new int[size];
            top = -1;
        }

        public void push(int value) {
            stack[++top] = value;
        }

         public int pop() {
            if (!isEmpty()) {
                return stack[top--];
            }
            return -1;
        }

        public int peek() {
            if (!isEmpty()) {
                return stack[top];
            }
            return -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
    
}
