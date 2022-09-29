package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17299_시간초과 {
	private static int[] NGF;
	private static int[] A;
	private static int[] F = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int len = A.length;
		NGF = new int[len];
		
		for(int i = 0; i < len; i++) {
			F[A[i]]++;
		}
		System.out.println(Arrays.toString(F));
		
		for(int t = 0; t < len; t++) {
			int value = -1;
			for(int i = t + 1; i < len; i++) {
				if(F[A[t]] < F[A[i]]) {
					value = A[i];
					break;
				}
			}
			NGF[t] = value;
		}
		for(int i = 0; i < len; i++)
			sb.append(NGF[i]).append(" ");
		
		System.out.println(sb);
	}
}