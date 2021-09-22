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
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				bfs(i, j);
			}
			System.out.println();
		}
	}
	
	private static void bfs(int startNode, int targetNode) {
		if(startNode == targetNode) return;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(startNode);
		visited[startNode] = true;
		int cnt = 1;
		
		outer : while(!q.isEmpty()) {
			int start = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && map[start][i] == 1) {
					q.offer(i);
					visited[i] = true;
					
					if(i == targetNode) {
						break outer;
					}
				}
			}
			cnt++;
		}
		System.out.print(cnt + " ");
	}
}
