package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
	static int map[][];
	static int sum(int r, int c, int num) {
		int sum = 0;
		for(int i = r; i < r + num; i++) {
			for(int j = c; j < c + num; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int n = 0, m = 0;
		
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int max_sum = Integer.MIN_VALUE;
				
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n - m + 1; i++) {
				for(int j = 0; j < n - m + 1; j++) {
					if(max_sum < sum(i, j, m))
						max_sum = sum(i, j, m);
				}
			}
			sb.append(max_sum).append("\n");
		}
		System.out.println(sb);
	}
}
