package swea;

import java.io.*;

public class swea_1986 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			
			if(n % 2 == 0) {
				sb.append(-n/2);
			}else {
				sb.append((n+1)/2);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
