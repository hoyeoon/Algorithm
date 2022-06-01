package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());	// 3 4
		int C = Integer.parseInt(st.nextToken());	// 4 2
		int S = Integer.parseInt(st.nextToken());	// 2 1
		int N = 2 * S + 1;							// 5 3
		
		int startX = R - S - 1;						// 0 2
		int startY = C - S - 1;						// 1 0
		for(int s = 0; s < S; s++) {
			int temp = map[startX + s][startY + s];
			for(int i = startX + s; i < startX + N - 1 - s; i++) { // 좌측 열 변경
				System.out.println(i);
				map[i][startY + s] = map[i + 1][startY + s];
			}
			System.out.println("----------------");
			for(int j = startY + s; j < startY + N - 1 - s; j++) { // 아래 행 변경
				System.out.println(j);
				map[startX + N - 1 - s][j] = map[startX + N - 1 - s][j + 1];
			}
			System.out.println("----------------");
			for(int i = startX + s; i < startX + N - 1 - s; i++) { // 우측 열 변경
				System.out.println(i);
				map[N - 1 - i][startY + N - 1 - s] = map[N - 2 - i][startY + N - 1 - s];
			}
			System.out.println("----------------");
			for(int j = startY + s; j < startY + N - 1 - s; j++) { // 위 행 변경
				System.out.println(j);
				map[startX + s][startY + N - j] = map[startX + s][startY + N - j - 1];
			}
			System.out.println("----------------");
			map[startX + s][startY + s + 1] = temp;
//			for(int i = s; i < m - 1 - s; i++) { // 위 행 변경
//				map[s][i] = map[s][i + 1];
//			}
//			map[startX + 1][startY] = temp;	// temp로 변경
		}
		
		
		
//		for(int s = 0; s < S; s++) {
//			int temp = map[s][s];
//			for(int i = s; i < m - 1 - s; i++) { // 위 행 변경
//				map[s][i] = map[s][i + 1];
//			}
//			for(int i = s; i < n - 1 - s; i++) { // 우측 열 변경
//				map[i][m - 1 - s] = map[i + 1][m - 1 - s];
//			}
//			for(int i = s; i < m - 1 - s; i++) { // 아래 행 변경
//				map[n - 1 - s][m - 1 - i] = map[n - 1 - s][m - 2 - i];
//			}
//			for(int i = s; i < n - 1 - s; i++) { // 좌측 열 변경
//				map[n - 1 - i][s] = map[n - 2 - i][s];
//			}
//			map[s + 1][s] = temp;	// temp로 변경
//		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
