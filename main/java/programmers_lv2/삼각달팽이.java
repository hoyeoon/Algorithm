package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
    int n;

    public int[] solution(int n) {
        this.n = n;
        int[][] arr = new int[n][n];
        makeArray(arr);

        return makeAnswer(arr);
    }

    private int[] makeAnswer(int[][] arr){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                list.add(arr[i][j]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void makeArray(int[][] arr){
        int cnt = n - 1;
        int row = 0;
        int col = 0;
        int val = 1;

        while(cnt > 0){
            for(int i = 0; i < cnt; i++){
                arr[row][col] = val;
                row++;
                val++;
            }
            for(int i = 0; i < cnt; i++){
                arr[row][col] = val;
                col++;
                val++;
            }
            for(int i = 0; i < cnt; i++){
                arr[row][col] = val;
                row--;
                col--;
                val++;
            }
            row += 2;
            col++;
            cnt -= 3;
        }

        if(cnt == 0){
            arr[row][col] = val;
        }
    }
}
