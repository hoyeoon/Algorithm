package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int flag = 0;	// 0 이면 happy, 1이면 sad
			st = new StringTokenizer(br.readLine(), " ");	// 상근이네 집
			int[] loc1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] loc2;
			for(int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");	//	편의점
				loc2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
				if(calDist(loc1, loc2) > 1000) {
					flag = 1;
				}
				loc1 = loc2;
			}
			st = new StringTokenizer(br.readLine(), " ");	// 펜타포트 락 페스티벌
			loc2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			if(calDist(loc1, loc2) > 1000) {
				flag = 1;
			}
			
			if(flag == 1) {
				sb.append("sad");
			}
			else {
				sb.append("happy");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int calDist(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
	}
}
