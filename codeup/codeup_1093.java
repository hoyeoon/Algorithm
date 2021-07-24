package codeup;

import java.io.*;
import java.util.*;

public class codeup_1093 {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[23];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			arr[Integer.parseInt(st.nextToken()) - 1]++;
		}
		
		for(int i = 0; i < arr.length; i++)
			sb.append(arr[i]).append(" ");
		
		System.out.println(sb);
	}
}