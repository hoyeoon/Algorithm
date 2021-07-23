package swea;

import java.io.*;
import java.util.*;

public class swea_2071 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double sum = 0;
			int num = 0;
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				sum += n;
				num++;
			}
			sb.append("#").append(i).append(" ").append((int)Math.round(sum / num)).append("\n");
		}
		System.out.println(sb);
	}
}
