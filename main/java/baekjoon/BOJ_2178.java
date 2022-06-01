package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = arr[j];
			}
		}
		
		q.offer(new int[]{0, 0});
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			int x = loc[0];
			int y = loc[1];
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
		
		System.out.println(map[N - 1][M - 1]);
	}
}
