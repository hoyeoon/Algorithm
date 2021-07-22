package codeup;

import java.io.*;

public class codeup_1027 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("[.]");
		
		System.out.printf("%02d-%02d-%04d", 
				Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
	}
}