package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
	static int minCnt = Integer.MAX_VALUE;	// A를 B로 바꾸는데 필요한 연산의 최솟값
	static int a, b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		bfs();
		
		if(minCnt == Integer.MAX_VALUE) minCnt = -1;
		else minCnt++;
		
		System.out.println(minCnt);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();	// curr(현재 값), cnt(연산 횟수)를 담는 Queue 자료형
		q.offer(new int[] {a, 0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int curr = info[0];
			int cnt = info[1];
			
			if(curr > b) continue;	// 백트래킹
			
			if(curr == b) {
				minCnt = Math.min(minCnt, cnt); 
				continue;
			}
			
			q.offer(new int[] {curr * 2, cnt + 1});
			q.offer(new int[] {Integer.parseInt(Integer.toString(curr) + "1"), cnt + 1});
		}
	}
}
