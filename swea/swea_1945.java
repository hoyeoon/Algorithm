package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1945 {
	public static void main(String[] args) throws Exception {
		int[] N = {2, 3, 5, 7, 11};
		int[] answer = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
				
		for(int i = 1; i <= T; i++) {
			answer = new int[5];
			int idx = 0;
			int count = 0;
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(i);
			
			while(n != 1) {
				if(n % N[idx] == 0) {
					n /= N[idx];
					count++;
				} else {
					answer[idx] = count;
					
					count = 0;
					idx++;
				}
			}
			answer[idx] = count;
			for(int j = 0; j < answer.length; j++) {
				sb.append(" ").append(answer[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
