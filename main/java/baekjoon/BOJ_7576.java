package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		answer = 0;	// 토마토가 모두 익을 때까지의 최소 날짜
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == 1) {
					q.offer(new int[] {i, j, 0});	// i, j, cnt
				}
			}
		}
		
		// 저장될 때부터 모든 토마토가 익어있는 상태이면 0 출력
		if(!checkFunc()) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		// 토마토가 모두 익지는 못하는 상황이면 -1 출력
		if(checkFunc()) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int loc[] = q.poll();
			int x = loc[0];
			int y = loc[1];
			int cnt = loc[2];
			answer = cnt;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = 1;
					q.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
	}

	// 0 이 하나라도 있으면 return true, 없으면 return false
	private static boolean checkFunc() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
