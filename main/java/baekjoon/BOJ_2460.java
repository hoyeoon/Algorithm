package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2460 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 0;
		int answer = Integer.MIN_VALUE;
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			count = count - out + in;
			
			answer = Math.max(answer,  count);
		}
		
		System.out.println(answer);
	}
}
