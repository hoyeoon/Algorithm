package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int s = 0; s < Math.min(n, m) / 2; s++) {
			for(int r = 0; r < R; r++) {
				int temp = map[s][s];
				for(int i = s; i < m - 1 - s; i++) { // 위 행 변경
					map[s][i] = map[s][i + 1];
				}
				for(int i = s; i < n - 1 - s; i++) { // 우측 열 변경
					map[i][m - 1 - s] = map[i + 1][m - 1 - s];
				}
				for(int i = s; i < m - 1 - s; i++) { // 아래 행 변경
					map[n - 1 - s][m - 1 - i] = map[n - 1 - s][m - 2 - i];
				}
				for(int i = s; i < n - 1 - s; i++) { // 좌측 열 변경
					map[n - 1 - i][s] = map[n - 2 - i][s];
				}
				map[s + 1][s] = temp;	// temp로 변경
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
