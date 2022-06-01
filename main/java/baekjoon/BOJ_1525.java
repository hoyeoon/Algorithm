package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1525 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int minMoveCnt = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int x, y;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[3][3];
		visited = new boolean[3][3];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		findZero();
		System.out.println(x + ", " + y);
		visited[x][y] = true;
		dfs(x, y, 0, "");
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	private static void dfs(int x, int y, int cnt, String path) {
		if(cnt >= answer) return;	// 백트래킹
		
		if(mapCheck()) {	// map 종료조건
			answer = Math.min(answer, cnt);
			path = path + "[" + x + "," + y + "]";
			System.out.println(path);
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
			
			if(!visited[nx][ny]) {
				// map[x][y] <-> map[nx][ny] 치환
				int temp = map[nx][ny];
				map[nx][ny] = 0;
				map[x][y] = temp;
				visited[nx][ny] = true;
				
				dfs(nx, ny, cnt + 1, path + "[" + x + "," + y + "], ");
				
				// map[x][y] <-> map[nx][ny] 재 치환(원상복구)
				map[x][y] = 0;
				map[nx][ny] = temp;
				visited[nx][ny] = false;
			}	
		}
	}
	
	// map == [[1, 2, 3], [4, 5, 6], [7, 8, 0]] 체크
	private static boolean mapCheck() {
		int num = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] != num) break;
				num++;
			}
		}
		return num == 9 ? true : false;
	}
	
	// 초기 0 위치 구하기
	private static void findZero() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
	}
}