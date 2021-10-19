package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
	static int minTime = Integer.MAX_VALUE;	// 수빈이가 동생을 찾는 가장 빠른 시간
	static int minTimeCase = 0; 			// 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수
	static int N, K;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 수빈 위치
		K = Integer.parseInt(st.nextToken());	// 동생 위치
		bfs1();
		bfs2();
		System.out.println(minTime);
		System.out.println(minTimeCase);
	}

	private static void bfs2() {
		visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();	// 수빈의 위치(x), 시간(time)을 담는 queue 자료형
		q.offer(new int[] {N, 0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int x = info[0];
			int time = info[1];
			
			
			if(time > minTime) continue;
			if(x < 0 || x > 100000) continue;
			
			if(x == K && time == minTime) {
				minTimeCase++;
			}
			
			if(!visited[x]) {
				q.offer(new int[] {x - 1, time + 1});
				q.offer(new int[] {x + 1, time + 1});
				q.offer(new int[] {x * 2, time + 1});
			}
			visited[x] = true;
		}
	}

	private static void bfs1() {
		visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();	// 수빈의 위치(x), 시간(time)을 담는 queue 자료형
		q.offer(new int[] {N, 0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int x = info[0];
			int time = info[1];
			
			if(time >= minTime) continue;
			if(x < 0 || x > 100000) continue;
			
			if(x == K) {
				minTime = Math.min(minTime, time);
			}
			
			if(!visited[x]) {
				q.offer(new int[] {x - 1, time + 1});
				q.offer(new int[] {x + 1, time + 1});
				q.offer(new int[] {x * 2, time + 1});
			}
			visited[x] = true;
		}
	}
}