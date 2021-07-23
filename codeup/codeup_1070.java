package codeup;

import java.io.*;

public class codeup_1070 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int month = Integer.parseInt(br.readLine());
		String season = null;
		
		switch(month)
		{
			case 12:
			case 1:
			case 2:
				season = "winter";
				break;
			case 3:
			case 4:
			case 5:
				season = "spring";
				break;
			case 6:
			case 7:
			case 8:
				season = "summer";
				break;
			case 9:
			case 10:
			case 11:
				season = "fall";
				break;
		}
		System.out.println(season);
	}
}