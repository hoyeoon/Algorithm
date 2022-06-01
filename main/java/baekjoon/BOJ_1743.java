package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
	static int N, M, K;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int maxCnt = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(maxCnt);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		q.offer(new int[] {i, j});
		map[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int r = loc[0];
			int c = loc[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dx[d];
				int nc = c + dy[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == 1) {
					cnt++;
					q.offer(new int[] {nr, nc});
					map[nr][nc] = 0;
				}
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
}
