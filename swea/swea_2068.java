package swea;

import java.io.*;
import java.util.*;

public class swea_2068 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				max = n > max ? n : max;
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
