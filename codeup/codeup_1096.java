package codeup;

import java.io.*;
import java.util.*;

public class codeup_1096 {
	public static void main(String[] args) throws Exception {
		int[][] map = new int[19][19];
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		int r = 0;
		int c = 0;
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}