package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503 {
	// 북, 동, 남, 서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, r, c, d;
	static int[][] map;
	static int answer = 0;
	static int cnt = 0;
	static int flag = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		System.out.println(Arrays.deepToString(map));
		
		while(true) {
			int check = 0;
			for(int d = 0; d < 4; d++) {
				if(map[r + dr[d]][c + dc[d]] == 0) {
					check = 1;
					break;
				}
			}
			// 네 방향 모두 청소가 이미 되어있거나 벽인 경우
			if(check == 0) {
				
				
				
			}
			
			if(flag == 1) map[r][c] = 1;
			d = (d + 3) % 4;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if(map[nr][nc] == 0) {
				r = nr;
				c = nc;
				flag = 1;
				continue;
			} else if(map[nr][nc] == 1) {
				r = nr;
				c = nc;
				flag = 2;
			}
			
			
			
		}
	}
}
