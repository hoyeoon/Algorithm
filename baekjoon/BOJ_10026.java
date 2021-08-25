package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static char[][] map1, map2;
	static boolean[][] visited1, visited2;
	static int cnt1, cnt2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N]; 
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		cnt1 = cnt2 = 0;
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				char c = str[j].charAt(0);
				map1[i][j] = c;
				if(c == 'G') {
					map2[i][j] = 'R';
				}else {
					map2[i][j] = c;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited1[i][j]) {
					bfs(visited1, map1, i, j);
					cnt1++;
				}
				if(!visited2[i][j]) {
					bfs(visited2, map2, i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
	
	private static void bfs(boolean[][] visited, char[][] map, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = loc[0] + dx[d];
				int ny = loc[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(!visited[nx][ny]) {
					if(map[loc[0]][loc[1]] == map[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
