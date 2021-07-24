package codeup;

import java.io.*;
import java.util.*;

public class codeup_1073 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}
}
