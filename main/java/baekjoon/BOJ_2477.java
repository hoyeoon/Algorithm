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
		// 참고 : 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
		int cnt3 = 0;	// 남쪽 개수
		int cnt4 = 0;	// 북쪽 개수
		int target;
		int answer = 0;
		
		int[] v = new int[6];	// 최대 2개의 변을 저장할 배열 
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(idx == 3) cnt3++;
			if(idx == 4) cnt4++;
			q.offer(new int[] {idx, len});
		}
		
		target = cnt3 > cnt4 ? 4 : 3;	// 4는 좌우 ㄱ 모양, 3은 좌우 ㄴ 모양
		
		// 시작점을 ㄱ모양의 경우 북쪽(4)으로, ㄴ모양의 경우 남쪽(3)으로 변경
		while(q.peek()[0] != target) {
			q.offer(q.poll());
		}
		
		// 변경된 queue에서 변의 값만 가져옴
		for(int i = 0; i < 6; i++) {
			v[i] = q.poll()[1];
		}
		
		// 넓이 = 큰 사각형 넓이 - 작은 사각형 넓이
		if(v[1] > v[5]) {	// ㄱ, ㄴ 모양일 경우
			answer = v[0]*v[1] - v[3]*v[4];
		}else {	// 좌우 반전된 ㄱ, ㄴ 모양일 경우
			answer = v[0]*v[5] - v[2]*v[3]; 
		}
		
		System.out.println(answer * K);
	}
}
