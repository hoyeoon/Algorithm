package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[L + 1];
		int expectMax = 0;
		int expectIdx = 0;
		int actualMax = 0;
		int actualIdx = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int actualCnt = 0;
			
			if(expectMax < to - from) {
				expectMax = to - from;
				expectIdx = i;
			}
			
			for(int k = from; k <= to; k++) {
				if(arr[k] == 0) {
					arr[k] = i;
					actualCnt++;
				}
			}
			if(actualMax < actualCnt) {
				actualMax = actualCnt;
				actualIdx = i;
			}
		}
		System.out.printf("%d%n%d", expectIdx, actualIdx);
	}
}
