package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static int R, C, answer = 0;
	static boolean[][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		System.out.println(Arrays.deepToString(map));
		
		for(int r = 0; r < R; r++) {
			dfs(r, 0);
		}
		
//		System.out.println(Arrays.deepToString(map));
		System.out.println(answer);
	}
	
	private static boolean dfs(int x, int y) {
		visited[x][y] = true;
		
		if(y == C - 1) {
			answer++;
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(map[nx][ny] == '.' && visited[nx][ny] == false) {
					// 
					if(dfs(nx, ny)) 
						return true;
				}
			}
		}
		return false;
	}
}
