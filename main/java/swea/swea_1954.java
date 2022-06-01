package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1954 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, -1, 0, 1};
			
			for(int i = 1; i <= n; i++)
				map[0][i - 1] = i;
			
			int x = 0;
			int y = n - 1;
			int count = n;
			int value = n;
			
			int d = 0;
			while(count-- > 1) {
				for(int k = 0; k < 2; k++) {
					for(int i = 0; i < count; i++) {
						x += dx[d % 4];
						y += dy[d % 4];
						value++;
						map[x][y] = value;
					}
					d++;
				}
			}
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					sb.append(map[r][c]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
