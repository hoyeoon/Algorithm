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
	static Queue<Integer> q = new LinkedList<>();
	
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
				if(visited[i] == true) continue;
				if(visited[i] == false) cnt++;
					
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						visited[i] = true;
						q.offer(j);
						
						while(!q.isEmpty()) {
							int x = q.poll();
							int flag = 0;
							
							for(int k = 0; k < N; k++) {
								if(visited[x] == false && map[x][k] == 1) {
									flag = 1;
									q.offer(k);
								}
							}
							if(flag == 1) {
								visited[x] = true;
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
