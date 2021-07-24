package codeup;

import java.io.*;
import java.util.*;

public class codeup_1074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		while(n > 0) {
			sb.append(n).append("\n");
			n--;
		}
		
		System.out.println(sb);
	}
}