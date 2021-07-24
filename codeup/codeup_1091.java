package codeup;

import java.io.*;
import java.util.*;

public class codeup_1091 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long a = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		long d = Integer.parseInt(st.nextToken());
		long n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n - 1; i++) {
			a = a * m + d;
		}
		
		System.out.println(a);
	}
}