package codeup;

import java.io.*;
import java.util.*;

public class codeup_1080 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int i = 1;
		int sum = 0;
		
		while(sum < n) 
			sum += i++;
		System.out.println(i - 1);
		
	}
}