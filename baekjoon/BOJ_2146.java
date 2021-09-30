package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	static int N;
	static int[][] map;
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int land;
	static int minBridge = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		land = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 육지를 구분하기 위한 부분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					markLand(i, j);
				}
			}
		}

		// 두 대륙을 연결할 수 있는 가장 짧은 다리의 길이를 구하는 부분
		for (int l = 2; l <= land; l++) {
			connectLand(l);
		}

		System.out.println(minBridge - 1);
	}

	private static void connectLand(int land) {
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N]; 
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == land) {
					q.offer(new int[] {i, j});
					dist[i][j] = 1;	// 현재 육지인 곳의 길이를 1로 초기화
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			if(dist[x][y] >= minBridge) continue;	// 백트래킹
			
			for(int d = 0; d < 3; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny]) continue;
				
				// 다른 육지에 도달한 경우
				if(map[nx][ny] != 0 && map[nx][ny] != land) {
					minBridge = Math.min(minBridge, dist[x][y]);
					return;
				}
				
				// 이동할 수 있는 곳일 경우
				if(map[nx][ny] == 0 && dist[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
				}	
			}
		}
	}

	private static void markLand(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		land++;

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			map[x][y] = land;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (map[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}