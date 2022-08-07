package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int m, n;
    int[][] arr;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.m = m;
        this.n = n;
        this.arr = new int[m][n];
        copy(picture, arr);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0){
                    int sizeOfOneArea = bfs(i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private void copy(int[][] picture, int[][] arr) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = picture[i][j];
            }
        }
    }

    private int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int colorNumber = arr[x][y];
        arr[x][y] = 0;
        int sizeOfOneArea = 1;

        while(!q.isEmpty()){
            int[] loc = q.poll();
            int currX = loc[0];
            int currY = loc[1];

            for(int i = 0; i < 4; i++){
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n){
                    continue;
                }
                if(arr[nextX][nextY] != colorNumber){
                    continue;
                }

                arr[nextX][nextY] = 0;
                sizeOfOneArea++;
                q.add(new int[]{nextX, nextY});
            }
        }
        return sizeOfOneArea;
    }
}
