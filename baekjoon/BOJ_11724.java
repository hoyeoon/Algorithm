package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
			map[c][r] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				cnt++;
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						q.offer(j);
						
						while(!q.isEmpty()) {
							int x = q.poll();
							
							for(int y = 0; y < N; y++) {
								if(!visited[y] && map[x][y] == 1) {
									visited[x] = true;
									visited[y] = true;
									q.offer(y);
								}
							}
							
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
