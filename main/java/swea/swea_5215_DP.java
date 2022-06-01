package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 재료의 수
			int L = Integer.parseInt(st.nextToken());	// 제한 칼로리
			
			int[] scores = new int[N + 1];		// 맛에 대한 점수
			int[] calories = new int[N + 1];	// 칼로리
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());				
			}
			
			int[][] D = new int[N + 1][L + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int w = 1; w <= L; w++) {
					if(calories[i] <= w) {	// 해당 물건을 가방에 넣을 수 있다.
						D[i][w] = Math.max(D[i - 1][w], scores[i] + D[i - 1][w - calories[i]]);
					} else {	// 해당 물건을 가방에 넣을 수 없다.
						D[i][w] = D[i - 1][w];
					}
				}
			}
			sb.append(D[N][L]).append("\n");
		}
		System.out.println(sb);
	}
}
