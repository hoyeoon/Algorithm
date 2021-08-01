package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		int totalSize = n * n;
		int r = 0;
		int c = 0;
		int count = 1;
		int[] direction = {0, 1, 2, 3}; // 0이면 열 + 이동, 1이면 행 + 이동, 2이면 열 - 이동, 3이면 행 - 이동
		int idx = 0;
		
		while(totalSize-- > 0) {
			map[r][c]++;
			
//			if(r == n - 1 ||  c == n - 1 || map[r+1][c] != 0 || map[r][c+1] != 0)
//				idx++;
			if(map[r][c] == 0)
				idx++;
			
			if(direction[idx % 4] == 0) c++;
			if(direction[idx % 4] == 1)	r++;
			if(direction[idx % 4] == 2) c--;
			if(direction[idx % 4] == 3) r--;
			
			System.out.println(idx);
		}
		
		System.out.println(Arrays.deepToString(map));
	}
	
}
