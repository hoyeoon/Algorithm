package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
	public static void main(String[] args) throws Exception{
		int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
		int dy[] = {-1, 1, 0, -1, 1, -1, 0, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q = new LinkedList<>();
		int map[][];
		int count;
		
		while(true) {
			count = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						count++;
						q.offer(new int[]{i, j});
						while(!q.isEmpty()) {
							int[] loc = q.poll();
							
							for(int d = 0; d < 8; d++) {
								int nx = loc[0] + dx[d];
								int ny = loc[1] + dy[d];
								
								if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0) continue;
								
								if(map[nx][ny] == 1) {
									map[nx][ny] = 2;
									q.offer(new int[] {nx, ny});
								}
							}
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}
