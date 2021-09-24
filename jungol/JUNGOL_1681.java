package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1681 {
	static int N, answer;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		dfs(0, 1, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int node, int depth, int sum) {
		if(depth == N) {
			if(map[node][0] != 0) {	// map[node][0] == 0 인 경우 1로 가는 방법이 없으므로 불가능
				answer = Math.min(answer, sum + map[node][0]);
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(sum + map[node][i] >= answer) continue;	// 백트래킹
			
			if(!visited[i] && map[node][i] != 0) {
				visited[i] = true;
				dfs(i, depth + 1, sum + map[node][i]);
				visited[i] = false;
			}
		}
	}
}
