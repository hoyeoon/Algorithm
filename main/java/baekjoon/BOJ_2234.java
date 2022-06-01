package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {
	static int n, m;
	static int[][] map, input, roomNo;
	static int roomCount;	// 이 성에 있는 방의 개수
	static int maxRoomArea;	// 가장 넓은 방의 넓이
	static int maxRoomAreaByRemoveOneWall;	// 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
	static int[] dx = {0, -1, 0, 1};	// 서, 북, 동, 남
	static int[] dy = {-1, 0, 1, 0};	// 서, 북, 동, 남
	
	// 벽에 대한 정보(0 ~ 15)에 대해 이동할 수 있는 위치 정보를 배열로 나타낸 것(dx, dy의 index로 활용)
	static int[][] wall = {{0,1,2,3},{1,2,3},{0,2,3},{2,3},{0,1,3},{1,3},{0,3},{3},{0,1,2},{1,2},{0,2},{2},{0,1},{1},{0},{}};
	static Queue<int[]> q;		// bfs를 사용하기 위해 만든 queue
	static Queue<int[]> info;	// 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기를 구하기 위해 사용하는 queue
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		input = new int[m][n];
		roomNo = new int[m][n];
		roomCount = 0;						
		maxRoomArea = Integer.MIN_VALUE;
		maxRoomAreaByRemoveOneWall = Integer.MIN_VALUE;
		
		q = new LinkedList<>();
		info = new LinkedList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 이 성에 있는 방의 개수(roomCount++), 가장 넓은 방의 넓이를 구하는 부분(bfs)
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					roomCount++;
					bfs(i, j);
				}
			}
		}
		// 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기를 구하는 부분
		getMaxRoomAreaByRemoveOneWall();
		
		System.out.println(roomCount);
		System.out.println(maxRoomArea);
		System.out.println(maxRoomAreaByRemoveOneWall);
	}

	private static void getMaxRoomAreaByRemoveOneWall() {
		for(int i = 0; i < m - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				// 현재 위치와 아래 행의 위치의 합을 비교
				if(roomNo[i][j] != roomNo[i + 1][j]) {
					maxRoomAreaByRemoveOneWall = Math.max(maxRoomAreaByRemoveOneWall, map[i][j] + map[i + 1][j]);
				}
				// 현재 위치와 오른쪽 열의 위치의 합을 비교
				if(roomNo[i][j] != roomNo[i][j + 1]) {
					maxRoomAreaByRemoveOneWall = Math.max(maxRoomAreaByRemoveOneWall, map[i][j] + map[i][j + 1]);
				}
			}
		}
		
		// 마지막 열
		for(int i = 0; i < m - 1; i++) {
			// 현재 위치와 아래 행의 위치의 합을 비교
			if(roomNo[i][n - 1] != roomNo[i + 1][n - 1]) {
				maxRoomAreaByRemoveOneWall = Math.max(maxRoomAreaByRemoveOneWall, map[i][n - 1] + map[i + 1][n - 1]);
			}
		}
		
		// 마지막 행
		for(int j = 0; j < n - 1; j++) {
			// 현재 위치와 오른쪽 열의 위치의 합을 비교
			if(roomNo[m - 1][j] != roomNo[m - 1][j + 1]) {
				maxRoomAreaByRemoveOneWall = Math.max(maxRoomAreaByRemoveOneWall, map[m - 1][j] + map[m - 1][j + 1]);
			}	
		}
	}

	private static void bfs(int i, int j) {
		q.offer(new int[] {i, j});
		info.offer(new int[] {i, j});
		map[i][j] = 1;
		int nextValue = 1;	// 방의 크기를 구하기 위해 이동한 수를 세는 변수
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			for(int idx : wall[input[x][y]]) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = ++nextValue;
					q.offer(new int[] {nx, ny});
					info.offer(new int[] {nx, ny});
				}
			}
		}
		maxRoomArea = Math.max(maxRoomArea, nextValue);
		
		makeMap(nextValue);	// map에서 이동한 부분을 nextValue로 칠한다.
	}

	private static void makeMap(int nextValue) {
		while(!info.isEmpty()) {
			int[] loc = info.poll();
			int x = loc[0];
			int y = loc[1];
			map[x][y] = nextValue;
			roomNo[x][y] = roomCount;
		}
	}
}
