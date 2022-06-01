package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
	static int minCost = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		dfs(0, 0, 1);	// 첫번째 노드에서 시작
		System.out.println(minCost);
	}

	private static void dfs(int node, int cost, int cnt) {
		if(cnt == N) {
			if(map[node][0] != 0) {	// 첫번째 노드로 가는 경로가 있을 경우
				minCost = Math.min(minCost, cost + map[node][0]);
			}
			return;
		}
		
		if(minCost <= cost) return;	// 백트래킹
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && map[node][i] != 0) {
				visited[i] = true;
				dfs(i, cost + map[node][i], cnt + 1);
				visited[i] = false;
			}
		} 
	}
}
