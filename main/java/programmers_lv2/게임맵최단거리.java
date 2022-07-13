package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] maps;
    int n, m;

    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;

        bfs();

        return maps[n - 1][m - 1] != 1 ? maps[n - 1][m - 1] : -1;
    }

    private void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] loc = q.poll();
            int x = loc[0];
            int y = loc[1];

            if(x == n - 1 && y == m - 1) return;

            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1) continue;
                if(maps[nextX][nextY] != 1) continue;

                maps[nextX][nextY] += maps[x][y];
                q.offer(new int[]{nextX, nextY});
            }
        }
    }
}
