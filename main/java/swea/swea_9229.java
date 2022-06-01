package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	static int N, M;
	static int weights[];
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weights = new int[N];
			answer = -1;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				weights[i] = Integer.parseInt(st.nextToken());
			
			combination(0, 0, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start, int sum) {
		if(cnt == 2){
			if(sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}
		for(int i = start; i < N; i++) {
			combination(cnt + 1, i + 1, sum + weights[i]);
		}
	}
}
