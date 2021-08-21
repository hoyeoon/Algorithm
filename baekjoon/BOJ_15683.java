package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] rotateCnt = {0, 4, 2, 4, 4, 1};	// 회전 수 (1, 2, 3, 4, 5) idx를 1부터 사용하기 위해 0 추가
	
	// 1~5번 돌아야하는 방향(dx, dy의 idx)
	static int[][] D = {{}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};
	
	static List<int[]> cctv;
	static int[][] map;
	static int N, M;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v >= 1 && v <= 5) cctv.add(new int[]{i, j});
			}
		}
		recursive(0, map);
		System.out.println(answer);
	}
	
	private static void recursive(int cnt, int[][] map) {
		if(cnt == cctv.size()) {
			answer = Math.min(answer, count0(map));
			return;
		}
		int x = cctv.get(cnt)[0];
		int y = cctv.get(cnt)[1];
		int n = map[x][y];
		
		for(int i = 0; i < rotateCnt[n]; i++) {
			int[][] copyMap = copyMap(map);
			
			for(int j = 0; j < D[n].length; j++) {
				int dir = (D[n][j] + i) % 4;
				
				int tempX = x;
				int tempY = y;
				while(true) {
					tempX += dx[dir];
					tempY += dy[dir];
					
					if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M || copyMap[tempX][tempY] == 6)
						break;
					
					if(copyMap[tempX][tempY] != 0) {
						continue;
					}

					copyMap[tempX][tempY] = 9;
				}
			}
			recursive(cnt + 1, copyMap);
		}
	}
	
	private static int count0(int map[][]) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	private static int[][] copyMap(int map[][]){
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}
}
