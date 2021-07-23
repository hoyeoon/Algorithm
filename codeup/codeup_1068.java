package codeup;

import java.io.*;

public class codeup_1068 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char grade;
		
		if(n >= 90)
			grade = 'A';
		else if(n >= 70)
			grade = 'B';
		else if(n >= 40)
			grade = 'C';
		else
			grade = 'D';
		
		System.out.println(grade);
	}
}