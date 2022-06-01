package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] map;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String str = "";
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				str = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}			
			int mid = n / 2;
			int sum = 0;
			for(int i = 0; i <= mid; i++) {
				for(int j = mid - i; j <= mid + i; j++) {
					sum += map[i][j];
				}
			}
			for(int i = mid + 1; i < n; i++) {
				for(int j = i - mid; j < n - (i - mid); j++) {
					sum += map[i][j];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
