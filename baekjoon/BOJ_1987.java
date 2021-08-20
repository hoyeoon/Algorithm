package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R, C;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 1, answer = 1;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < C; j++) {
				map[i][j] = str[j].charAt(0) - 65;
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y) {
		int v = map[x][y];
		visited[v] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(visited[map[nx][ny]] == false) {
					cnt++;
					answer = Math.max(answer, cnt);
					dfs(nx, ny);
				}
			}
		}
		cnt--;
		visited[v] = false;
	}
}
