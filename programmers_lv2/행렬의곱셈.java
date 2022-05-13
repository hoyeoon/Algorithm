package programmers_lv2;

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr1[0].length; // arr2.length
        int z = arr2[0].length;

        int[][] answer = new int[x][z];

        for(int i = 0; i < x; i++){
            for(int j = 0; j < z; j++){
                for(int n = 0; n < y; n++){
                    answer[i][j] += arr1[i][n] * arr2[n][j];
                }
            }
        }

        return answer;
    }
}
