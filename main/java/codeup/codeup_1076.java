package codeup;

import java.io.*;
import java.util.*;

public class codeup_1076 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		char n =st.nextToken().charAt(0);
		int count = n - 'a';
		
		
		for(int i = 0; i <= count; i++) {
			sb.append((char)('a' + i)).append(" ");
		}
		
		System.out.println(sb);
	}
}