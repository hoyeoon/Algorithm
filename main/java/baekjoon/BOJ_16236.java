package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class BOJ_16236 {
	static int N;
	static int x, y;		// 아기 상어의 위치
	static int size = 2;	// 아기 상어의 처음 크기
	static int eated = 0;	// 아기 상어가 먹은 물고기 개수
	static int time = 0;	// 물고기를 잡아먹을 수 있는 시간
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 9) {
					x = i;
					y = j;
				}
				map[i][j] = v;
			}
		}
		
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			if(eated == size) {
				eated = 0;
				size++;
			}
			
			int[] loc = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = loc[0] + dx[d];
				int ny = loc[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] > size) continue;
				
				if(visited[nx][ny] == false && map[nx][ny] >= 1 && map[nx][ny] < size) {
					visited[nx][ny] = true;
					eated++;
					q.offer(new int[] {nx, ny});
					time++;
				}
			}
		}
		
		System.out.println(size);
		System.out.println(eated);
		System.out.println(time);
	}
}
