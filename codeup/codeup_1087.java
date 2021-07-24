package codeup;

import java.io.*;
import java.util.*;

public class codeup_1087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int i = 1;
		while(sum < n) {
			sum += i++;
		}
		System.out.println(sum);
	}
}