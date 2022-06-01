package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_Dijkstra {
	public static void main(String[] args) throws Exception {
		int answer = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[1000001];
		q.offer(new int[] {N, 0});	// 수빈의 위치와 현재 시간을 담는 배열을 활용하여  bfs를 돌린다.
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int X = info[0];	// X는 수빈의 현재 위치
			int T = info[1];	// 시간 초
			
			if(T >= answer) continue;
			if(X < 0 || X >= 1000001) continue;
			
			if(X == K) {
				answer = Math.min(answer, T);
			}
			
			if(!visited[X]) {
				q.offer(new int[] {X - 1, T + 1});
				q.offer(new int[] {X + 1, T + 1});
				q.offer(new int[] {X * 2, T + 1});
			}
			visited[X] = true;
		}
		System.out.println(answer);
	}
}