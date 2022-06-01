package swea;

import java.util.Arrays;

public class test {
	static int map[][] = new int[10][10];
	static int c;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		c = 3;
		makeMap(0, 9, 6);
		System.out.println(Arrays.deepToString(map));
	}
	
	static void makeMap(int cnt, int x, int y) {
		if(cnt == c) {
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
			map[nx][ny] = 1;
			makeMap(cnt + 1, nx, ny);
		}
	}
}
