package swea;

import java.io.*;
import java.util.*;

public class swea_2072 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(n % 2 != 0)
					sum += n;
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
