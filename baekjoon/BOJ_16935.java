package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st.nextToken();
		int[][] map = new int[n][m];
		int[][] temp = null;
		int r, c;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		String[] str = br.readLine().split(" "); 
		int[] selected = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		
		for(int t = 0; t < selected.length; t++) {
			switch(selected[t]) {
			case 1:
				int[] temp1 = new int[m];
				r = map.length;
				for(int i = 0; i < r / 2; i++) {
					temp1 = map[i];
					map[i] = map[r - 1 - i];
					map[r - 1 - i] = temp1;
				}
				break;
			case 2:	
				int temp2 = 0;
				r = map.length;
				c = map[0].length;
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c / 2; j++) {
						temp2 = map[i][j];
						map[i][j] = map[i][c - 1 - j];
						map[i][c - 1 - j] = temp2;
					}
				}
				break;
			case 3:
				r = map.length;
				c = map[0].length;
				temp = new int[c][r];
				for(int i = 0; i < c; i++) {
					for(int j = 0; j < r; j++) {
						temp[i][j] = map[r - 1 - j][i];
					}
				}
				map = temp;
				break;
			case 4:
				r = map.length;
				c = map[0].length;
				temp = new int[c][r];
				for(int i = 0; i < c; i++) {
					for(int j = 0; j < r; j++) {
						temp[i][j] = map[j][c - 1 - i];
					}
				}
				map = temp;
				break;
			case 5:
				r = map.length;
				c = map[0].length;
				temp = new int[r][c];
				for(int i = 0; i < r / 2; i++) {
					for(int j = 0; j < c / 2; j++) {
						temp[i][j] = map[r / 2 + i][j];
						temp[r / 2 + i][j] = map[r / 2 + i][c / 2 + j];
						temp[r / 2 + i][c / 2 + j] = map[i][c / 2 + j];
						temp[i][c / 2 + j] = map[i][j];
					}
				}
				map = temp;
				break;
			case 6:
				r = map.length;
				c = map[0].length;
				temp = new int[r][c];
				for(int i = 0; i < r / 2; i++) {
					for(int j = 0; j < c / 2; j++) {
						temp[i][j] = map[i][c / 2 + j];
						temp[r / 2 + i][j] = map[i][j];
						temp[r / 2 + i][c / 2 + j] = map[r / 2 + i][j];
						temp[i][c / 2 + j] = map[r / 2 + i][c / 2 + j];
					}
				}
				map = temp;
				break;
			}
		}
		print(sb, map);
	}

	private static void print(StringBuilder sb, int[][] map) {
		int n = map.length;
		int m = map[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
