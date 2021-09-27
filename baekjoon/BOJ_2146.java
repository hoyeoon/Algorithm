package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int land;
	static int minBridge = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		land = 1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 육지를 구분하기 위한 부분
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		// 두 대륙을 연결할 수 있는 가장 짧은 다리의 길이를 구하는 부분
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					connectLand(i, j, 0);
				}
			}
		}
		
		System.out.println(minBridge);
	}

	private static void connectLand(int i, int j, int cnt) {
		if(cnt >= minBridge) return;
		
		int curr = map[i][j];
		
		for(int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == curr) continue;
			
			if(map[nx][ny] != 0) {
				minBridge = Math.min(minBridge, cnt);
				return;
			}
			
			if(cnt + 1 >= minBridge) return;
			
			map[nx][ny] = curr;
			connectLand(nx, ny, cnt + 1);
			map[nx][ny] = 0;
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		land++;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = land;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
