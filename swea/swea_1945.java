package swea;

import java.io.*;
import java.util.Arrays;

public class swea_1945 {
	public static void main(String[] args) throws Exception {
		int[] answer = new int[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int m = 2;
		int count = 0;
		int idx = 0;
		
//		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			while(n != 1) {
				if(n % m == 0) {
					n /= m;
					count++;
				} else {
					m++;
					answer[idx] = count;
					count = 0;
					idx++;
				}
			}
//		}
		System.out.println(Arrays.toString(answer));
	}
}
