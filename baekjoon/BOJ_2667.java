package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {
	static int N;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new LinkedList<>();
		int totalCnt = 0;
		List<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = arr[j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					totalCnt++;
					answer.add(bfs(i, j));
				}
			}
		}
		
		System.out.println(totalCnt);
		Collections.sort(answer);
		for(int cnt : answer) {
			System.out.println(cnt);
		}
	}
	
	private static int bfs(int i, int j) {
		q.offer(new int[] {i, j});
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = loc[0] + dx[d];
				int ny = loc[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] == 0) continue;
				
				cnt++;
				map[nx][ny] = 0;
				q.offer(new int[] {nx, ny});
			}			
		}
		
		if(cnt != 1) cnt--;
		
		return cnt;
	}
}
