package codeup;

import java.io.*;

public class codeup_1099 {
	static char[][] map = new char[10][10];
	static int r = 1;
	static int c = 1;
	static int i = 0;
	static int j = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		
		if(map[r][c] == '2') {
			map[r][c] = '9';
			result(sb);
			return;
		}
		map[r][c] = '9';
		
		while(true) {
			if(map[r+i][c+j+1] == '2') {
				map[r+i][c+j+1] = '9';
				result(sb);
				return;
			}
			
			if(map[r+i][c+j+1] == '0')
				j++;
			else if(map[r+i+1][c+j] == '0')
				i++;
			else {
				if(map[r+i][c+j+1] == '2')
					map[r+i][c+j+1] = '9';
				if(map[r+i+1][c+j] == '2')
					map[r+i+1][c+j] = '9';
				break;
			}
			
			if(map[r+i][c+j] == '2') {
				result(sb);
				return;
			}
			map[r+i][c+j] = '9';	
		}
		result(sb);
	}

	private static void result(StringBuilder sb) {
		for(int m = 0; m < 10; m++) {
			for(int n = 0; n < 10; n++) {
				sb.append(map[m][n]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		return;
	}
}