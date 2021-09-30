package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5643 {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static int visited_cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1]; 
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				visited_cnt = 0;
				asc_bfs(i);
				desc_bfs(i);
				if(visited_cnt == N - 1) answer++;	// 방문 수가 전체 노드 수 - 1(자기자신 제외)인 경우에만 전체를 확인할 수 있다는 의미
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	// 자신보다 아래있는 노드 찾기
	private static void desc_bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int n = 1; n <= N; n++) {
				if(!visited[n] && map[n][curr] == 1) {
					q.offer(n);
					visited[n] = true;
					visited_cnt++;
				}
			}
		}
	}

	// 자신보다 위에있는 노드 찾기
	private static void asc_bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int n = 1; n <= N; n++) {
				if(!visited[n] && map[curr][n] == 1) {
					q.offer(n);
					visited[n] = true;
					visited_cnt++;
				}
			}
		}
	}
}
