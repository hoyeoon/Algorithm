package programmers_lv2;

public class 행렬테두리회전하기 {
    int[][] map;
    int n, m;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        this.n = rows;
        this.m = columns;
        this.map = new int[n][m];
        initMap();

        for(int i = 0; i < queries.length; i++){
            answer[i] = rotateAndFindMinValue(queries[i]);
        }

        return answer;
    }

    private int rotateAndFindMinValue(int[] query){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int n = query[2] - query[0];
        int m = query[3] - query[1];
        int temp = map[x1][y1];
        int minValue = temp;

        for(int i = 0; i < n; i++){
            map[x1 + i][y1] = map[x1 + 1 + i][y1];
            minValue = Math.min(minValue, map[x1 + i][y1]);
        }

        for(int i = 0; i < m; i++){
            map[x1 + n][y1 + i] = map[x1 + n][y1 + 1 + i];
            minValue = Math.min(minValue, map[x1 + n][y1 + i]);
        }

        for(int i = 0; i < n; i++){
            map[x1 + n - i][y1 + m] = map[x1 + n - 1 - i][y1 + m];
            minValue = Math.min(minValue, map[x1 + n - i][y1 + m]);
        }

        for(int i = 0; i < m; i++){
            map[x1][y1 + m - i] = map[x1][y1 + m - 1 - i];
            minValue = Math.min(minValue, map[x1][y1 + m - i]);
        }

        map[x1][y1 + 1] = temp;

        return minValue;
    }

    private void initMap(){
        int num = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = num++;
            }
        }
    }
}
