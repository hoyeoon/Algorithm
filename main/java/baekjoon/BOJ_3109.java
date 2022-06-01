package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 총 경우의 수 3^500 * 10000 -> 가지치기 필수
 * 
 * 가지치기
 * : 파이프 놓기에 성공했다면 시작열(처음으로 계속 리턴), 단 성공한 방식이 최선이라고 판단이 되어야 한다.(놓는 순서를 위에서부터)
 * : 이전 파이프 놓기에 실패한 흔적 남겨둔다. 만약, 지우면 실패했던 자리에서 또 똑같이 진행해야해서 문제가 생김
 * */

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
			return true;	// 다른 방향을 체크하지 않고 돌아감. how? 재귀의 특성. return하면 전에 호출했던 데로 간다.
		}
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(map[nx][ny] == '.' && visited[nx][ny] == false) {
					if(dfs(nx, ny)) 	// 성공하면 다음 방향은 볼 필요가 없다.
						return true;	// 다른 방향을 체크하지 않고 돌아감. how? 재귀의 특성. return하면 전에 호출했던 데로 간다.	
				}
			}
			
			// 뒤에 나온 선택지의 방향은 현재보다 유리하지 않은 상황이다. 따라서 같은 상황이 되풀이된다.
			// 이거하면 실패했던 위치에서 다시 또 해본다. 주의
			// visited[nx][ny] = false;
		}
		return false;	// 세방향 모두 갈 수 있는 경우가 없었음
	}
}
