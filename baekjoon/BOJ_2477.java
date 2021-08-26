package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2477 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<int[]> q = new LinkedList<>();
		int K = Integer.parseInt(br.readLine());
		int cnt3 = 0;
		int cnt4 = 0;
		
		// 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
		int[][] size = new int[5][2];
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(idx == 3) cnt3++;
			if(idx == 4) cnt4++;
			q.offer(new int[] {idx, len});
		}
		System.out.println(q);
		if(cnt3 > cnt4) {	// ㄱ, 좌우 반전 ㄱ 모양
			// 북쪽 4를 시작점으로 변경
			while(q.peek()[0] != 4) {
				q.offer(q.poll());
			}
			
			
			
		}else {	// ㄴ, 좌우반전 ㄴ 모양
			// 남쪽 3을 시작점으로 변경
			while(q.peek()[0] != 3) {
				q.offer(q.poll());
			}
			
			
			
		}
		
		System.out.println(q);
	}
}
