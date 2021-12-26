package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2693 {
	public static void main(String[] args) throws Exception {
		Integer arr[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			arr = new Integer[10];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			System.out.println(arr[2]);
		}
	}
}
