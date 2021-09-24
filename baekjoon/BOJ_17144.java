package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C, T;
	static int[][] map;
	static Queue<int[]> munji;
	static List<Integer> machine;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		munji = new LinkedList<>();		// 미세먼지의 위치(r, c)와 미세먼지의 양을 담는 queue
		machine = new ArrayList<>();	// 공기청정기의 위치(r)을 담는 리스트. 공기청정기는 항상 0열에 위치하므로 r 정보만 저장
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c = 0; c < C; c++) {
				int value = Integer.parseInt(st.nextToken());
				
				if(value == -1) {
					machine.add(r);
				}
				map[r][c] = value;
			}
		}
		
		// T초간 반복
		while(T-- > 0) {
			saveMunji(); // queue에 미세먼지 정보(위치, 값) 저장
			
			// map 초기화
			map = new int[R][C];
			map[machine.get(0)][0] = -1;
			map[machine.get(1)][0] = -1;
			
			// 1. 미세먼지의 확산
			while(!munji.isEmpty()) {
				int loc[] = munji.poll();
				int x = loc[0];
				int y = loc[1];
				int value = loc[2];
				int cnt = 0;	// 확산된 방향의 개수
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
					
					cnt++;
					map[nx][ny] += value / 5;	// 확산되는 양
				}
				map[x][y] += value - (value / 5) * cnt;	// r, c에 남은 미세먼지 양
			}
			
			// 2. 공기청정기 작동
			int r1 = machine.get(0);	// 위쪽 공기 청정기의 행
			int r2 = machine.get(1);	// 아래쪽 공기 청정기의 행		
			
			// 위쪽 공기청정기 - 반시계방향 순환
			for(int r = 1; r < r1; r++) {
				map[r1 - r][0] = map[r1 - r - 1][0];
			}
			for(int c = 0; c < C - 1; c++) {
				map[0][c] = map[0][c + 1];
			}
			for(int r = 0; r < r1; r++) {
				map[r][C - 1] = map[r + 1][C - 1];
			}
			for(int c = 0; c < C - 2; c++) {
				map[r1][C - 1 - c] = map[r1][C - 2 - c];
			}
			map[r1][1] = 0;
			
			// 아래쪽 공기청정기 - 시계방향 순환
			for(int r = 1; r < R - r2 - 1; r++) {
				map[r2 + r][0] = map[r2 + r + 1][0];
			}
			for(int c = 0; c < C - 1; c++) {
				map[R - 1][c] = map[R - 1][c + 1];
			}
			for(int r = 0; r < R - r2 - 1; r++) {
				map[R - 1 - r][C - 1] = map[R - 2 - r][C - 1];
			}
			for(int c = 0; c < C - 2; c++) {
				map[r2][C - 1 - c] = map[r2][C - 2 - c];
			}
			map[r2][1] = 0;
		}
		System.out.println(totalMunji());
	}
	
	private static void saveMunji() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] != 0 && map[r][c] != -1) {
					munji.offer(new int[] {r, c, map[r][c]});
				}
			}
		}		
	}
	
	private static int totalMunji() {
		int sum = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sum += map[r][c];
			}
		}
		return sum + 2;
	}
}
