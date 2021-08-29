package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] students = new int[7][2];	// 학년(1~6), 성별(0~1)
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			students[Y][S]++;
		}
		
		for(int y = 1; y <= 6; y++) {
			for(int s = 0; s <= 1; s++) {
				answer += (students[y][s] / K) + (students[y][s] % K != 0 ? 1 : 0);
			}
		}
		System.out.println(answer);
	}
}
