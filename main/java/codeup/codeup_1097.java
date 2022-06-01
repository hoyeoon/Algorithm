package codeup;

import java.io.*;
import java.util.*;

public class codeup_1097 {
	public static void main(String[] args) throws Exception {
		char[][] map = new char[19][19];
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 19; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int row = arr[0] - 1;
			int col = arr[1] - 1;
			
			for(int k = 0; k < 19; k++) {
				map[k][col] = (map[k][col] == '1') ? '0' : '1';
				map[row][k] = (map[row][k] == '1') ? '0' : '1';
			}
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