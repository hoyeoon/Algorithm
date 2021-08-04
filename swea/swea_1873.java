package swea;

import java.util.Scanner;

public class swea_1873 {
	static char[][] map;
	static int r = 0, c = 0;
	static char pos;
	static int h = 0, w = 0;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			h = sc.nextInt();
			w = sc.nextInt();
			
			map = new char[h][w];
			for(int i = 0; i < h; i++) {
				map[i] = sc.next().toCharArray();
			}
//			System.out.println(Arrays.deepToString(map));
			
			outer : for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						r = i;
						c = j;
						pos = map[i][j];
						break outer;
					}
				}
			}
			
			int n = sc.nextInt();
			char[] action = sc.next().toCharArray();
//			System.out.println(Arrays.toString(action));
			for(int i = 0; i < n; i++) {
				switch(action[i]) {
					case 'U':
						up();
//						System.out.println(action[i] + Arrays.deepToString(map));
//						System.out.println(r + " " + c);
						break;
					case 'D':
						down();
//						System.out.println(action[i] + Arrays.deepToString(map));
//						System.out.println(r + " " + c);
						break;
					case 'L':
						left();
//						System.out.println(action[i] + Arrays.deepToString(map));
//						System.out.println(r + " " + c);
						break;
					case 'R':
						right();
//						System.out.println(action[i] + Arrays.deepToString(map));
//						System.out.println(r + " " + c);
						break;
					case 'S':
						shoot();
//						System.out.println(action[i] + Arrays.deepToString(map));
//						System.out.println(r + " " + c);
						break;
				}
			}
//			System.out.println(r + " " + c);
//			System.out.println(Arrays.deepToString(map));
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
	static void up() {
		pos = '^';
		
		if(r - 1 < 0 || r - 1 >= h || c < 0 || c >= w || map[r - 1][c] != '.') {
			map[r][c] = pos;
			return;
		}
		if(map[r - 1][c] == '.') {
			map[r][c] = '.';
			r -= 1;
		}
		map[r][c] = pos;
	}
	static void down() {
		pos = 'v';
		
		if(r + 1 < 0 || r + 1 >= h || c < 0 || c >= w || map[r + 1][c] != '.') {
			map[r][c] = pos;
			return;
		}
		if(map[r + 1][c] == '.') {
			map[r][c] = '.';
			r += 1;
		}
		map[r][c] = pos;
	}
	static void left() {
		pos = '<';
		
		if(r < 0 || r >= h || c - 1 < 0 || c - 1 >= w || map[r][c - 1] != '.') {
			map[r][c] = pos;
			return;
		}
		if(map[r][c - 1] == '.') {
			map[r][c] = '.';
			c -= 1;
		}
		map[r][c] = pos;
	}
	static void right() {
		pos = '>';
		
		if(r < 0 || r >= h || c + 1 < 0 || c + 1 >= w || map[r][c + 1] != '.') {
			map[r][c] = pos;
			return;
		}
		if(map[r][c + 1] == '.') {
			map[r][c] = '.';
			c += 1;
		}
		map[r][c] = pos;
	}
	static void shoot() {
		int tr = r;
		int tc = c;
		switch(map[tr][tc]) {
			case '^':
				while(true) {
					if(tr - 1 < 0 || tr - 1 >= h || tc < 0 || tc >= w || map[tr - 1][tc] == '#') 
						break;
					
					if(map[tr - 1][tc] == '.' || map[tr - 1][tc] == '-') {
						tr -= 1;
						continue;
					}
					if(map[tr - 1][tc] == '*') {
						map[tr - 1][tc] = '.';
						break;
					}
				}
				break;
			case 'v':
				while(true) {
					if(tr + 1 < 0 || tr + 1 >= h || tc < 0 || tc >= w || map[tr + 1][tc] == '#') 
						break;
					if(map[tr + 1][tc] == '.' || map[tr + 1][tc] == '-') {
						tr += 1;
						continue;
					}
					if(map[tr + 1][tc] == '*') {
						map[tr + 1][tc] = '.';
						break;
					}
				}
				break;
			case '<':
				while(true) {
					if(tr < 0 || tr >= h || tc - 1 < 0 || tc - 1 >= w || map[tr][tc - 1] == '#') 
						break;
					if(map[tr][tc - 1] == '.' || map[tr][tc - 1] == '-') {
						tc -= 1;
						continue;
					}
					if(map[tr][tc - 1] == '*') {
						map[tr][tc - 1] = '.';
						break;
					}
				}
				break;
			case '>':
				while(true) {
					if(tr < 0 || tr >= h || tc + 1 < 0 || tc + 1 >= w || map[tr][tc + 1] == '#') 
						break;
					if(map[tr][tc + 1] == '.' || map[tr][tc + 1] == '-') {
						tc += 1;
						continue;
					}
					if(map[tr][tc + 1] == '*') {
						map[tr][tc + 1] = '.';
						break;
					}
				}
				break;
		}
	}
}