package codeup;

import java.io.*;
import java.util.*;

public class codeup_1078 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int n = Integer.parseInt(st.nextToken());
				
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0)
				sum += i;
		}
		
		System.out.println(sum);
	}
}