package codeup;

import java.io.*;
import java.util.*;

public class codeup_1079 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			char n = st.nextToken().charAt(0);
			sb.append(n).append("\n");
			
			if(n == 'q')
				break;
		}
		
		System.out.println(sb);
	}
}