package swea;

import java.io.*;
import java.util.*;

public class swea_2070 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			sb.append("#").append(i);
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a < b)
				sb.append(" <\n");
			else if(a == b)
				sb.append(" =\n");
			else
				sb.append(" >\n");
		}
		System.out.println(sb);
	}
}
