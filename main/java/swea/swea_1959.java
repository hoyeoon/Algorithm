package swea;

import java.io.*;
import java.util.Arrays;

public class swea_1959 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int max = Integer.MIN_VALUE; 
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int count = Math.abs(n - m) + 1;
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			sb.append("#").append(t);
			if(n < m) {
				for(int i = 0; i < count; i++) {
					int sum = 0;
					for(int j = i; j < i + n; j++) {
						sum += a[j - i] * b[j];
					}
					if(sum > max) max = sum;
				}
			}else {
				for(int i = 0; i < count; i++) {
					int sum = 0;
					for(int j = i; j < i + m; j++) {
						sum += a[j] * b[j - i];
					}
					if(sum > max) max = sum;
				}
			}
			sb.append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
