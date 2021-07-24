package codeup;

import java.io.*;
import java.util.*;

public class codeup_1083 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			String s = Integer.toString(i);
			if(s.contains("3") || s.contains("6") || s.contains("9"))
				sb.append("X");
			else
				sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}