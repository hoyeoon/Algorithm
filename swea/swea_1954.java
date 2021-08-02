package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		char[] direction = {'r', 'd', 'l', 'u'};
		int r = 0;
		int c = 0;
		int idx = 0;
		int answer = 0;
		
		while(answer++ < n) {
			if(r > n - 1 || c > n - 1 || r < 0 || c < 0){
				idx++;
			}
			map[r][c] = answer;
			if(direction[idx % 4] == 'r') c++;
			if(direction[idx % 4] == 'd') r++;
			if(direction[idx % 4] == 'l') c--;
			if(direction[idx % 4] == 'u') r--;
		}
		
		System.out.println(Arrays.deepToString(map));
		
		
	}
	
}
