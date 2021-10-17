package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {
	static long minCnt = Integer.MAX_VALUE;	// A를 B로 바꾸는데 필요한 연산의 최솟값
	static long a, b;	// ※ int형으로 하면 런타임 에러 발생
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		bfs();
		
		if(minCnt == Integer.MAX_VALUE) minCnt = -1;
		else minCnt++;
		
		System.out.println(minCnt);
	}

	private static void bfs() {
		Queue<long[]> q = new LinkedList<>();	// curr(현재 값), cnt(연산 횟수)를 담는 Queue 자료형
		q.offer(new long[] {a, 0});
		
		while(!q.isEmpty()) {
			long[] info = q.poll();
			long curr = info[0];
			long cnt = info[1];
			
			if(curr > b) continue;	// 백트래킹
			
			if(curr == b) {
				minCnt = Math.min(minCnt, cnt); 
				continue;
			}
			
			q.offer(new long[] {curr * 2, cnt + 1});
			q.offer(new long[] {Long.parseLong(curr + "1"), cnt + 1});
		}
	}
}
