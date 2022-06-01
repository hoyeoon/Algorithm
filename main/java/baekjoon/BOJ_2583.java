package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int M, N, K;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Integer> counts = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		q = new LinkedList<>();
		int answer = 0;
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int r = M - y2; r < M - y1; r++) {
				for(int c = x1; c < x2; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					answer++;
					counts.add(bfs(i, j));
				}
			}
		}
		counts.sort(Comparator.naturalOrder());
		System.out.println(answer);
		for(int cnt : counts) {
			System.out.print(cnt + " ");
		}
		
	}
	
	private static int bfs(int i, int j) {
		int cnt = 0;
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			cnt++;
			int[] loc = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = loc[0] + dx[d];
				int ny = loc[1] + dy[d];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == 1) continue;
				
				map[nx][ny] = 1;
				q.offer(new int[] {nx, ny});
			}
		}
		return cnt > 1 ? cnt - 1: cnt;
	}
}
