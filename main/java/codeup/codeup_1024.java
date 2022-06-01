package codeup;

import java.io.*;

public class codeup_1024 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] arr = str.split("");
		for(String s : arr) {
			System.out.printf("'%s'\n", s);
		}
	}
}