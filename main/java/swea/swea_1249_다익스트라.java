package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 입력
2
4
0100
1110
1011
1010
6
011001
010100
010011
101001
010101
111010
 */
public class swea_1249_다익스트라 {
	static int N, map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			
			sb.append(dijkstra(0,0)).append("\n");
			
		}
		System.out.println(sb);
		
	}

	private static int dijkstra(int startR, int startC) {
		
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		// 최소값이 갱신되도록 큰값으로 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		
		minTime[startR][startC] = 0;
		
		int r = 0, c = 0, minCost = 0, nr, nc;
		while(true) {
			// step1
			minCost = INF;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && minCost > minTime[i][j]) {
						minCost = minTime[i][j];
						r = i;
						c = j;
					}
				}
			}
			
			if(r == N - 1 && c == N - 1) return minCost;	// 도착지점
			
			visited[r][c] = true;
			
			// step2 : step1에서 선택된 정점을 경유지로 해서 인접정점 따져보기
			// 이 문제에서는 인접정점이 4방 정점
			for(int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(!visited[nr][nc] && minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
				}
			}
		}	
	}
}
