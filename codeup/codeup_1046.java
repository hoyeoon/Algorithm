package codeup;

import java.io.*;

public class codeup_1046 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		int sum = a+b+c;
		System.out.println(sum);
		System.out.printf("%.1f", (float)sum / str.length);
	}
}