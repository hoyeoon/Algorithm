package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		System.out.println(Arrays.deepToString(map));
		
		visited[0] = true;
		dfs(0, 0, 0);
		System.out.println(minCost);
	}

	private static void dfs(int node, int cost, int cnt) {
		if(minCost <= cost) return;
		
		if(cnt == N) {
			if(minCost > cost) {
				minCost = cost;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				dfs(i, cost + map[node][i], cnt + 1);
				
				visited[i] = false;
			}
		} 
	}
}
