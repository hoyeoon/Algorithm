package codeup;

import java.io.*;

public class codeup_1025 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("");
		StringBuilder sb = new StringBuilder();
				
		for(int i = 0; i < arr.length; i++) {
			sb.append("[");
			sb.append(arr[i]);
			
			for(int j = 1; j < arr.length - i; j++) {
				sb.append("0");
			}
			sb.append("]\n");
		}
		System.out.println(sb);
	}
}