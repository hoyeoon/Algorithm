package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
//		visited = new boolean[N][M];
		q = new LinkedList<>();
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == 1) {
					q.offer(new int[] {i, j});
//					visited[i][j] = true;
				}
			}
		}
		
		if(checkFunc() == 0) {
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {
			int loc[] = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = 1;
					answer++;
//					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static int checkFunc() {
		int check = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					check = 1;
					break;
				}
			}
		}
		return check;	
	}
}
