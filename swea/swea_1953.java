package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, R, C, L;
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(bfs(R, C)).append("\n");
		}
		System.out.println(sb);
		
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c, 1});	// r, c, 이동 시간
		visited[r][c] = true;
		int cnt = 1;	// 표시된 지점
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			int t = loc[2];
			
			if(t == L) break;
			
			if(map[x][y] == 1) {	// 상, 하, 좌, 우
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)) continue;
					if(d == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)) continue;
					if(d == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)) continue;
					if(d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 2) { // 상, 하
				for(int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)) continue;
					if(d == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 3) { // 좌, 우
				for(int d = 2; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)) continue;
					if(d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 4) { // 상, 우
				for(int d = 0; d < 4; d += 3) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)) continue;
					if(d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 5) { // 하, 우
				for(int d = 1; d < 4; d += 2) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)) continue;
					if(d == 3 && (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 6) { // 하, 좌
				for(int d = 1; d < 3; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 1 && (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)) continue;
					if(d == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			} else if(map[x][y] == 7) { // 상, 좌
				for(int d = 0; d < 4; d += 2) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(d == 0 && (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)) continue;
					if(d == 2 && (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)) continue;
					
					if(!visited[nx][ny] && map[nx][ny] != 0) {
						q.offer(new int[] {nx, ny, t + 1});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
