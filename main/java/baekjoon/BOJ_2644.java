package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	static int n, m, start, end;
	static int[][] map;
	static boolean[] visited;
	static Queue<int[]> q;	// 정점, count를 담는 int[] 변수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		System.out.println(bfs(start));		
	}
	private static int bfs(int start) {
		q.offer(new int[] {start, 1});
		visited[start] = true;
		int flag1 = 0;	// 목적지(end)에 도달하는 지 여부를 판단하기 위한 flag
		int answer = 0;
		
		outer : while(!q.isEmpty()) {
			int[] infos = q.poll();
			int from = infos[0];
			int cnt = infos[1];
			int flag2 = 0;	// 이동했는지 여부를 판단하기 위한 flag
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && map[from][i] == 1) {
					if(i == end) {
						flag1 = 1;
						answer = cnt;
						break outer;
					}
					flag2 = 1;
					q.offer(new int[] {i, cnt + 1});
					visited[i] = true;
				}
			}
			if(flag2 == 1) cnt++;
		}
		return flag1 == 0 ? -1 : answer;
	}
}
