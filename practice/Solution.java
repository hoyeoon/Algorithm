package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		int step = 0;
		
		while(t > 0) {
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			int n = Integer.parseInt(st.nextToken());
			
			char[][] area = new char[n][n];
			int[] heights = new int[n*n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					area[i][j] = st.nextToken().charAt(0);
				}
			}
			int cnt = 0;
			
		    for (int r = 0; r < n; r++) {
		        for (int c = 0; c < n; c++) {
		        	int height = 0;
		            if (area[r][c] == 'B') {
		                for (int d = 0; d < 8; d++) {
		                    int nr = r + deltas[d][0];
		                    int nc = c + deltas[d][1];
		                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && area[nr][nc] == 'G') {
		                        height += 2;
		                        break;
		                    }
		                }
		                if(height != 2) { // 인접 구획에 G가 없을 경우
		                	for (int i = 0; i < n; i++) {
		                		if (area[i][c] == 'B')
		                			height += 1;
		                		if (area[r][i] == 'B')
		                			height += 1;
		                	}
		                	height -= 1;
		                }
		            }
		            heights[cnt++] = height;
		        }
		    }
		    Arrays.sort(heights);
		    answer = heights[heights.length - 1];
		    System.out.printf("#%d %d\n", ++step, answer);
		    t--;
		}
	}
}