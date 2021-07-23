package codeup;

import java.io.*;

public class codeup_1065 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		for(int i = 0; i < str.length; i++) {
			if(Integer.parseInt(str[i]) % 2 == 0)
				System.out.println(str[i]);
		}
	}
}