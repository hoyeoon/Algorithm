package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7465 {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int cnt;
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N];
			cnt = 0;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = map[c][r] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i] == false && map[i][j] == 1) {
						visited[i] = true;
						cnt++;
						
						q.offer(new int[] {i, j});
						
						while(!q.isEmpty()) {
							int[] loc = q.poll();
							
							for(int k = 0; k < N; k++) {
								if(visited[loc[1]] == false && map[loc[1]][k] == 1) {
									visited[loc[1]] = true;
									q.offer(new int[] {loc[1], k});
								}
							}
						}
					}		
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
