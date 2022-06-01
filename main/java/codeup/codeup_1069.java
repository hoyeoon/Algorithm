package codeup;

import java.io.*;

public class codeup_1069 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = br.readLine().charAt(0);
		String str;
		
		switch(c)
		{
			case 'A': 
				str="best!!!";
				break;
			case 'B':
				str="good!!";
				break;
			case 'C':
				str="run!";
				break;
			case 'D':
				str="slowly~";
				break;
			default:
				str="what?";
		}
		System.out.println(str);
	}
}