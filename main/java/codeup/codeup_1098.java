package codeup;

import java.io.*;
import java.util.*;

public class codeup_1098 {
	public static void main(String[] args) throws Exception {				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] mapSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int h = mapSize[0];
		int w = mapSize[1];
		int[][] map = new int[h][w];
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int l = info[0];
			int d = info[1];
			int x = info[2] - 1;
			int y = info[3] - 1;
			
			if(d == 0) {
				for(int k = 0; k < l; k++) {
					map[x][y+k]++;
				}
			}else {
				for(int k = 0; k < l; k++) {
					map[x+k][y]++;
				}
			}
		}
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}