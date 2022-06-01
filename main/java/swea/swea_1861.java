package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int[][] map;
	static int[] record;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			record = new int[n*n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					for(int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if(nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;
						if(map[x][y] == map[nx][ny] - 1) {
							record[map[x][y] - 1]++;
						}	
					}
				}
			}
			int sum = 0;
			int maxValue = 0;
			int startIdx = 0;
			for(int i = 0; i < n * n; i++) {
				if(record[i] == 1) {
					sum++;
				}else {
					if(maxValue < sum) {
						maxValue = sum;
						startIdx = i;
					}
					sum = 0;
				}
			}
			startIdx = startIdx - maxValue + 1;
			maxValue++;
			sb.append(startIdx).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}