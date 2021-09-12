package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2606 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
			map[c][r] = 1;
		}
		
		q.offer(0);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i = 0; i < n; i++) {
				if(!visited[i] && map[x][i] == 1) {
//					System.out.println(x + ", " + i);
					set.add(i);
					q.offer(i);
				}
			}
			visited[x] = true;
		}
		System.out.println(set.size());
	}
}
