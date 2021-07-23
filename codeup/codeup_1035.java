package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codeup_1035 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine(), 16);
		
		System.out.printf("%o\n", n);
	}
}