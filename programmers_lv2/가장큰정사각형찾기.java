package programmers_lv2;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board)
    {
        int answer = 1234;
        int N = board.length;
        int M = board[0].length;
        int max_size = Integer.MIN_VALUE;
        int small_line = Math.min(N, M);

        outer1 : for(int n = 0; n < small_line; n++) {
            for(int i = 0; i < N - n; i++){
                outer2 : for(int j = 0; j < M - n; j++){
                    // System.out.println(i + ", " +j + ", " + n);

                    for(int x = 0; x < n + 1; x++){
                        for(int y = 0; y < n + 1; y++){
                            if(board[i + x][j + y] == 0) continue outer2;
                            // System.out.println(i + x + ", " + (j + y));
                        }
                    }
                    max_size = Math.max(max_size, (int)Math.pow(n + 1, 2));
                    continue outer1;
                }
            }
        }

        return max_size;
    }
}
