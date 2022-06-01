package codeup;

import java.io.*;
import java.util.*;

public class codeup_1077 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
				
		for(int i = 0; i <= n; i++) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}