package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_바이너리카운팅 {
	static int N;
	static int[] sour;
	static int[] bitter;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(binaryCounting());
//		System.out.println(min);
	}
	
	private static int binaryCounting() {
		int answer = Integer.MAX_VALUE;
		
		for(int i = 1; i < (1 << N); i++) {	// 1개 이상이므로 i = 1부터
			int multipleSour = 1;
			int sumBitter = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					multipleSour *= sour[j];
					sumBitter += bitter[j];
				}
			}
			answer = Math.min(answer, Math.abs(multipleSour - sumBitter));
		}
		return answer;
	}
}
