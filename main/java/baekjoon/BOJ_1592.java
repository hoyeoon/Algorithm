package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int i = 0, cnt = 0;
		
		while(true) {
			if(arr[i] % 2 == 1) {
				arr[(i + L) % N]++;
				i = (i + L) % N;
			}else {
				int v = i - L; 
				if(v < 0) {
					arr[N + v]++;
					i = N + v;
				}else {
					arr[v]++;
					i = v;
				}
			}
			if(arr[i] == M) break;
			cnt++;
		}
		System.out.println(cnt);
	}
}
