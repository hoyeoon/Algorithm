package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		int answer = 0; 
		int minBakon = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				cnt += bfs(i, j);
			}
			if(minBakon > cnt) {
				minBakon = cnt;
				answer = i;
			}
		}
		System.out.println(answer);
	}
	
	private static int bfs(int startNode, int targetNode) {
		if(startNode == targetNode) return 0;
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList<>(); // startNode, cnt 를 담는 Queue
		q.offer(new int[] {startNode, 1});
		visited[startNode] = true;
		int count = 0;
		
		outer : while(!q.isEmpty()) {
			int[] info = q.poll();
			int start = info[0];
			int cnt = info[1];
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && map[start][i] == 1) {
					if(i == targetNode) {
						count = cnt;
						break outer;
					}
					visited[i] = true;
					q.offer(new int[] {i, cnt + 1});
				}
			}
		}
		return count;
	}
}
