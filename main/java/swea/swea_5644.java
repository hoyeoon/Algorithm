package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5644 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int c, p;
	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int psum;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < A; i++) {
				psum = 0;
				map = new int[10][10];
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				
				makeMap(0, x - 1, y - 1);
			}
			System.out.println(Arrays.deepToString(map));
		}
		System.out.println(sb);
	}
	
	static void makeMap(int cnt, int x, int y) {
		if(cnt == c) return;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
			map[nx][ny] = p;
			makeMap(cnt + 1, nx, ny);
		}
	}
}
