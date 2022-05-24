package programmers_lv2;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board)
    {
        int N = board.length;
        int M = board[0].length;
        int small_line = Math.min(N, M);
        int max_size = Integer.MIN_VALUE;

        if(small_line == 1) return 1;

        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                int curr = board[i][j];

                if(curr != 0 && board[i-1][j] >= curr && board[i][j-1] >= curr && board[i-1][j-1] >= curr){
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                }
                max_size = Math.max(max_size, board[i][j]);
            }
        }

        return (int)Math.pow(max_size, 2);
    }
}
