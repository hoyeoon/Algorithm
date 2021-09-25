package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {
	static int n, m;
	static int[][] map, input;
	static int roomCount;
	static int maxRoomArea;
	static int[] dx = {0, -1, 0, 1};	// 서, 북, 동, 남
	static int[] dy = {-1, 0, 1, 0};	// 서, 북, 동, 남
	
	// 벽에 대한 정보 0 ~ 15 에 대한 위치 index정보(dx, dy의  index로 활용)
	static int[][] wall = {{},{0},{1},{0,1},{2},{0,2},{1,2},{0,1,2},{3},{0,3},{1,3},{0,1,3},{2,3},{0,2,3},{1,2,3},{0,1,2,3}};
	static Queue<int[]> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		input = new int[m][n];
		roomCount = 0;
		maxRoomArea = Integer.MIN_VALUE;
		q = new LinkedList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Arrays.deepToString(input));
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				bfs(i, j);
			}
		}
		
		
	}

	private static void bfs(int i, int j) {
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			
			input[x][y]
				
			
			
		}
	}
}
