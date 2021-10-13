package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int blueCnt, whiteCnt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(whiteCnt + " " + blueCnt);
	}

	private static void bfs(int i, int j) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(!visited[nx][ny] && map[i][j] == map[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		if(map[i][j] == 'B') blueCnt += (int) Math.pow(cnt, 2);
		if(map[i][j] == 'W') whiteCnt += (int) Math.pow(cnt, 2);
	}
}
