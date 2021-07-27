package swea;

import java.io.*;
import java.util.Arrays;

public class swea_1959 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int count = Math.abs(n - m) + 1;
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max = Integer.MIN_VALUE; 
		
		if(n < m) {
			for(int i = 0; i < count; i++) {
				int sum = 0;
				for(int j = i; j < i + n; j++) {
					sum += a[i] + b[i];
				}
				if(sum > max) max = sum;
			}
		}
		System.out.println(max);
//		else {
//			
//		}
	}
}
