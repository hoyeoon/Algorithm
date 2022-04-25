package programmers_lv1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
	Stack<Integer> stack = new Stack<>();
    int[][] board;
    int answer = 0;

    void function(int move) {
        for(int i = 0; i < board.length; i++){
            if(board[i][move - 1] != 0){
                if(!stack.empty() && stack.peek() == board[i][move - 1]){
                    stack.pop();
                    answer += 2;
                } else {
                   stack.push(board[i][move - 1]);
                }
                board[i][move - 1] = 0;
                break;
            }
        }
    }

    public int solution(int[][] board, int[] moves) {
        this.board = board;
        for(int move : moves){
            function(move);
        }
        return answer;
    }
}
