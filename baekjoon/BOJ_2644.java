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
	static Queue<Integer> q;
	
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
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		System.out.println(bfs(start));		
	}
	private static int bfs(int start) {
		q.offer(start);
		visited[start] = true;
		int cnt = 1;
		int flag1 = 0;	// 목적지(end)에 도달하는 지 여부를 판단하기 위한 flag
		
		outer : while(!q.isEmpty()) {
			int from = q.poll();
			int flag2 = 0;	// 이동했는지 여부를 판단하기 위한 flag
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && map[from][i] == 1) {
					if(i == end) {
						flag1 = 1;
						break outer;
					}
					flag2 = 1;
					q.offer(i);
					visited[i] = true;
				}
			}
			if(flag2 == 1) cnt++;
		}
		return flag1 == 0 ? -1 : cnt;
	}
}
